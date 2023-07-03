import java.util.*;

public class ConsistentHashing1 {

    static class Solution3 {
        ArrayList<Integer> ans;
        Map<Integer, TreeSet<String>> serverMap;
        Map<Integer, List<Request>> requestsMap;
        Map<String, Integer> serverHashes;

        static class Request {
            int hash;
            String name;

            String serverName;

            Request(int hash, String name, String serverName) {
                this.hash = hash;
                this.name = name;
                this.serverName = serverName;
            }
        }

        int userHash(String username, int hashKey) {
            int p = hashKey;
            int n = 360;
            long hashCode = 0;
            long p_pow = 1;
            for (int i = 0; i < username.length(); i++) {
                char character = username.charAt(i);
                hashCode = (hashCode + (character - 'A' + 1) * p_pow) % n;
                p_pow = (p_pow * p) % n;
            }
            return (int) hashCode;
        }

        public ArrayList<Integer> solve(ArrayList<String> A, ArrayList<String> B, ArrayList<Integer> C) {
            ans = new ArrayList<>();
            serverMap = new TreeMap<>();
            requestsMap = new TreeMap<>();
            serverHashes = new TreeMap<>();

            int n = A.size();
            for (int i = 0; i < n; i++) {
                String command = A.get(i);
                String server = B.get(i);
                int key = C.get(i);
                int hash = userHash(server, key);
                if (command.equals("ADD")) {
                    //System.out.println("** ADDED server "+ server +" hash "+hash);
                    serverHashes.put(server, hash);
                    add(server, hash);
                } else if (command.equals("REMOVE")) {
                    remove(server, hash);
                } else {
                    assign(server, hash);
                }
            }
            return ans;
        }

        void add(String server, int hash) {

            if (serverMap.isEmpty()) {
                TreeSet<String> servers = new TreeSet<>();
                servers.add(server);
                serverMap.put(hash, servers);
                ans.add(0);
                return;
            }

            if (serverMap.containsKey(hash)) {
                serverMap.get(hash).add(server);
            } else {
                TreeSet<String> servers = new TreeSet<>();
                servers.add(server);
                serverMap.put(hash, servers);
            }
            //Check if requests need to assign to the new server
            //Find previous server hash
            Set<Integer> serverSet = serverMap.keySet();
            int prevServerHash = -1;
            for (int val : serverSet) {
                if (val < hash) {
                    prevServerHash = val;
                } else break;
            }

            if (prevServerHash != -1) {
                //Assign previous server requests to the new one
                int count = 0;
                for (Map.Entry<Integer, List<Request>> entry : requestsMap.entrySet()) {
                    int ringHash = entry.getKey();
                    if (ringHash >= prevServerHash + 1 && ringHash <= hash) {
                        List<Request> requests = entry.getValue();
                        for (Request p : requests) {
                            if (p.hash != hash) {
                                //System.out.println("*Request "+entry.getKey() +" is assigning to the server "+server +" "+hash);
                                p.hash = hash;
                                p.serverName = server;
                                count++;
                            }
                        }
                        entry.setValue(requests);
                    }
                }
                ans.add(count);
                return;
            }

            //Assign requests from last server
            for (int val : serverSet) {
                prevServerHash = val;
            }

            int count = 0;
            for (Map.Entry<Integer, List<Request>> entry : requestsMap.entrySet()) {
                int ringHash = entry.getKey();
                if ((ringHash >= prevServerHash + 1 && ringHash < 360) || (ringHash >= 0 && ringHash <= hash)) {
                    List<Request> requests = entry.getValue();
                    for (Request p : requests) {
                        if (p.hash != hash) {
                            //System.out.println("Request "+entry.getKey() +" is assigning to the server "+server +" "+hash);
                            p.hash = hash;
                            p.serverName = server;
                            count++;
                        }
                    }
                    entry.setValue(requests);
                }
            }
            ans.add(count);
            //System.out.println("******** ADD END *********");
        }

        void remove(String serverToRemove, int newHash) {
            int serverHash = serverHashes.get(serverToRemove);
            //System.out.println("Server to remove "+ serverToRemove +" "+serverHash);
            if (serverMap.get(serverHash).size() > 1) {
                //Assign its requests to the 2nd last server
                serverMap.get(serverHash).remove(serverToRemove);
                String serverName = serverMap.get(serverHash).first();
                int count = 0;
                for (Map.Entry<Integer, List<Request>> entry : requestsMap.entrySet()) {
                    List<Request> requests = entry.getValue();
                    for (Request p : requests) {
                        if (p.hash == serverHash && p.serverName.equalsIgnoreCase(serverToRemove)) {
                            //System.out.println("Request "+entry.getKey() +" is re-assigning to the server "+serverName +" "+serverHash);
                            count++;
                            p.hash = serverHash;
                            p.serverName = serverName;
                        }
                    }
                    entry.setValue(requests);
                }
                ans.add(count);


                return;
            }


            Set<Integer> serverSet = serverMap.keySet();
            int nextServer = -1;
            for (int val : serverSet) {
                if (val > serverHash) {
                    nextServer = val;
                    break;
                }
            }
            if (nextServer == -1) {
                // if no next server, then assign all request coming to this server to first server
                Optional<Integer> firstServer = serverSet.stream().findFirst();
                if (firstServer.isPresent()) {
                    nextServer = firstServer.get();
                }
            }

            int count = 0;
            String serverName = serverMap.get(nextServer).first();

            for (Map.Entry<Integer, List<Request>> entry : requestsMap.entrySet()) {
                List<Request> requests = entry.getValue();
                for (Request p : requests) {
                    if (p.hash == serverHash && p.serverName.equalsIgnoreCase(serverToRemove)) {
                        //System.out.println("Request "+entry.getKey() +" is re-assigning to the server "+serverName +" "+nextServer);
                        count++;
                        p.hash = nextServer;
                        p.serverName = serverName;
                    }
                }
                entry.setValue(requests);
            }
            ans.add(count);
            if (serverMap.get(serverHash).size() > 1) {
                serverMap.get(serverHash).remove(serverToRemove);
            } else {
                serverMap.remove(serverHash);
            }
            //System.out.println("******** REMOVE END *********");
        }

        void assign(String request, int hash) {
            Set<Integer> set = serverMap.keySet();
            //Find server >= hash
            int serverHash = -1;
            for (int val : set) {
                if (val >= hash) {
                    serverHash = val;
                    break;
                }
            }
            if (serverHash == -1) {
                Optional<Integer> firstServer = set.stream().findFirst();
                if (firstServer.isPresent()) {
                    serverHash = firstServer.get();
                }
            }

            String serverName = serverMap.get(serverHash).first();
            //System.out.println("Request "+hash +" is assigning to the server "+serverName +" "+serverHash);

            if (requestsMap.containsKey(hash)) {
                requestsMap.get(hash).add(new Request(serverHash, request, serverName));
            } else {
                List<Request> requests = new ArrayList<>();
                requests.add(new Request(serverHash, request, serverName));
                requestsMap.put(hash, requests);
            }
            ans.add(hash);
        }
    }

    private static void solve(String[] AA, String[] BB, Integer[] CC, String expectedResult) {
        ArrayList<String> A = new ArrayList<>();
        A.addAll(Arrays.asList(AA));

        ArrayList<String> B = new ArrayList<>();
        B.addAll(Arrays.asList(BB));

        ArrayList<Integer> C = new ArrayList<>();
        C.addAll(Arrays.asList(CC));

        System.out.println("*********** TEST CASE ***********");
        Solution3 solution = new Solution3();
        ArrayList<Integer> ans = solution.solve(A, B, C);
        System.out.println("Actual Result");
        PrintUtil.print(ans);
        System.out.println("Expected Result");
        System.out.println(expectedResult);
    }

    public static void main(String[] args) {
        String[] AA = new String[]{"ADD", "ASSIGN", "ASSIGN", "ASSIGN", "ADD", "ASSIGN", "ASSIGN", "ASSIGN", "ADD", "ASSIGN", "ASSIGN", "ASSIGN", "ADD", "ASSIGN", "ASSIGN", "ASSIGN", "REMOVE", "ASSIGN", "ASSIGN", "ASSIGN", "REMOVE", "ASSIGN", "ASSIGN", "ASSIGN", "REMOVE", "ASSIGN", "ASSIGN"};
        String[] BB = new String[]{"INDIA", "GYQF", "SSAH", "DVTQ", "RUSSIA", "ZIVQ", "VBWW", "ACDW", "CHINA", "YNXC", "MWUN", "NECZ", "GERMANY", "OOHQ", "RSTZ", "WRJJ", "INDIA", "YLDR", "XDFH", "SCCV", "RUSSIA", "QECH", "WPCA", "ZLVQ", "CHINA", "RQPJ", "PFWJ"};
        Integer[] CC = new Integer[]{947, 613, 821, 701, 193, 683, 19, 467, 503, 347, 433, 887, 971, 587, 509, 283, 727, 359, 443, 883, 499, 487, 853, 223, 137, 13, 739};
        solve(AA, BB, CC, "0 307 107 3 1 310 160 267 0 188 359 34 0 303 263 157 8 359 66 209 2 303 175 179 3 73 343");

        AA = new String[]{"ADD", "ASSIGN", "ASSIGN", "ASSIGN", "ADD", "ASSIGN", "ASSIGN", "ASSIGN", "ADD", "ASSIGN", "ASSIGN", "ASSIGN", "ADD", "ASSIGN", "ASSIGN", "ASSIGN", "REMOVE", "ASSIGN", "ASSIGN", "ASSIGN", "REMOVE", "ASSIGN", "ASSIGN", "ASSIGN", "REMOVE", "ASSIGN", "ASSIGN"};
        BB = new String[]{"INDIA", "ZLWJ", "LDFU", "PNPO", "RUSSIA", "KBVS", "JVTP", "PRIM", "CHINA", "JKJM", "NNMB", "NTWR", "GERMANY", "ZSTB", "WVAY", "VANM", "INDIA", "MXQB", "HLWW", "ZDPD", "RUSSIA", "SCFG", "JREC", "QIRT", "CHINA", "KJRU", "JCZT"};
        CC = new Integer[]{797, 107, 19, 5, 107, 823, 281, 787, 317, 137, 71, 241, 499, 293, 691, 311, 431, 877, 709, 599, 941, 449, 991, 467, 157, 757, 821};
        solve(AA, BB, CC, "0 27 133 201 0 228 28 182 0 356 83 75 2 7 341 310 5 320 126 154 10 195 306 42 14 96 199");


        AA = new String[]{"ADD", "ASSIGN", "ASSIGN", "ASSIGN", "ADD", "ASSIGN", "ASSIGN", "ASSIGN", "ADD", "ASSIGN", "ASSIGN", "ASSIGN", "ADD", "ASSIGN", "ASSIGN", "ASSIGN", "REMOVE", "ASSIGN", "ASSIGN", "ASSIGN", "REMOVE", "ASSIGN", "ASSIGN", "ASSIGN", "REMOVE", "ASSIGN", "ASSIGN"};
        BB = new String[]{"INDIA", "VLVL", "OXXV", "HHGN", "RUSSIA", "AWNF", "SPHI", "FXKT", "CHINA", "JXZU", "BWPK", "JYWN", "GERMANY", "ZKYK", "HLQZ", "BRMS", "INDIA", "FMVA", "NPJO", "GACA", "RUSSIA", "ZMWM", "XVUA", "IDUW", "CHINA", "EHWW", "KROX"};
        CC = new Integer[]{431, 563, 223, 761, 197, 409, 31, 223, 769, 619, 991, 613, 139, 797, 547, 821, 859, 131, 577, 269, 2, 499, 599, 29, 449, 13, 337};
        solve(AA, BB, CC, "0 260 337 317 3 116 202 157 0 51 232 180 0 281 123 152 6 62 271 188 4 63 262 213 11 167 284");

        AA = new String[]{"ADD", "ASSIGN", "ASSIGN", "ASSIGN", "ADD", "ASSIGN", "ASSIGN", "ASSIGN", "ADD", "ASSIGN", "ASSIGN", "ASSIGN", "ADD", "ASSIGN", "ASSIGN", "ASSIGN", "REMOVE", "ASSIGN", "ASSIGN", "ASSIGN", "REMOVE", "ASSIGN", "ASSIGN", "ASSIGN", "REMOVE", "ASSIGN", "ASSIGN"};
        BB = new String[]{"INDIA", "QASU", "WARW", "TDZH", "RUSSIA", "YPFH", "LHJQ", "TIXP", "CHINA", "MVHQ", "ILLW", "TFLP", "GERMANY", "HJKY", "CWAE", "XFKI", "INDIA", "YEOP", "TRVD", "RPPO", "RUSSIA", "ODDL", "VQXB", "RGIT", "CHINA", "FGFR", "IDVE"};
        CC = new Integer[]{263, 269, 503, 233, 179, 823, 743, 593, 11, 47, 389, 17, 197, 701, 503, 521, 131, 379, 541, 113, 313, 61, 991, 23, 349, 3, 229};
        solve(AA, BB, CC, "0 194 89 322 2 103 285 325 0 270 76 118 2 74 336 290 1 79 64 105 11 35 155 240 15 207 292");

        AA = new String[]{"ADD", "ASSIGN", "ADD", "ASSIGN", "REMOVE", "ASSIGN"};
        BB = new String[]{"INDIA", "NWFJ", "RUSSIA", "OYVL", "INDIA", "IGAX"};
        CC = new Integer[]{7, 3, 5, 13, 23, 17};
        solve(AA, BB, CC, "0 47 1 182 0 249");

        AA = new String[]{"ADD", "ASSIGN", "ASSIGN", "ADD", "ASSIGN", "ASSIGN", "REMOVE", "ASSIGN"};
        BB = new String[]{"INDIA", "IRYA", "RGJK", "RUSSIA", "BGVH", "SUKJ", "INDIA", "RBRF"};
        CC = new Integer[]{11, 31, 7, 3, 5, 13, 23, 17};
        solve(AA, BB, CC, "0 23 10 0 147 1 4 172");

        AA = new String[]{"ADD", "ASSIGN", "ASSIGN", "ADD", "ASSIGN", "ASSIGN", "REMOVE", "ASSIGN"};
        BB = new String[]{"INDIA", "GSZJ", "ORWX", "RUSSIA", "IENS", "TTXU", "INDIA", "CHEX"};
        CC = new Integer[]{211, 181, 919, 383, 571, 127, 977, 97};
        solve(AA, BB, CC, "0 242 116 1 47 139 2 256");
    }
}