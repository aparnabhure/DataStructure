import java.util.*;

//https://leetcode.com/contest/weekly-contest-303/problems/design-a-food-rating-system/
public class FoodRatingSystem {
    public static void main(String[] args) {
        FoodRatings foodRatings = new FoodRatings(new String[]{"kimchi", "miso", "sushi", "moussaka",
                "ramen", "bulgogi"},
                new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"},
                new int[]{9, 12, 8, 15, 14, 7});
        System.out.println(foodRatings.highestRated("korean")); // return "kimchi"
        // "kimchi" is the highest rated korean food with a rating of 9.
        System.out.println(foodRatings.highestRated("japanese")); // return "ramen"
        // "ramen" is the highest rated japanese food with a rating of 14.
        foodRatings.changeRating("sushi", 16); // "sushi" now has a rating of 16.
        System.out.println(foodRatings.highestRated("japanese")); // return "sushi"
        // "sushi" is the highest rated japanese food with a rating of 16.
        foodRatings.changeRating("ramen", 16); // "ramen" now has a rating of 16.
        System.out.println(foodRatings.highestRated("japanese")); // return "ramen"
        // Both "sushi" and "ramen" have a rating of 16.
        // However, "ramen" is lexicographically smaller than "sushi".
    }
    static class FoodRatings {

        Map<String, Food> fmap = new HashMap<>();
        Map<String, SortedSet<Food>> cMap = new HashMap<>();
        Comparator<Food> comp = Comparator.comparingInt(Food::getRating).thenComparing(Food::getName);

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            int n = foods.length;
            for(int i =0; i<n; i++){
                String food = foods[i];
                String cuisine = cuisines[i];
                int rating = ratings[i];
                Food f = new Food(food, cuisine, rating);
                fmap.put(food, f);

                SortedSet<Food> fset = cMap.getOrDefault(cuisine, new TreeSet<>());
                fset.add(f);
                cMap.put(cuisine, fset);
            }
        }

        public void changeRating(String food, int newRating) {
            if(fmap.containsKey(food)){
                Food f = fmap.get(food);


                SortedSet<Food> fset = cMap.getOrDefault(f.cuisine, new TreeSet<>());
                fset.remove(f);


                f.rating = newRating;
                fmap.put(food, f);

                fset.add(f);
                cMap.put(f.cuisine, fset);

            }
        }

        public String highestRated(String cuisine) {
            if(cMap.containsKey(cuisine)){
                SortedSet<Food> foods = cMap.get(cuisine);
                if(foods != null && !foods.isEmpty())  {
                    return foods.first().getName();
                }
            }
            return "";
        }

        class Food implements Comparable<Food>{
            String name;
            String cuisine;
            int rating;
            public Food(String name, String cuisine, int rating){
                this.name = name;
                this.cuisine = cuisine;
                this.rating = rating;
            }

            public String getName(){
                return this.name;
            }

            public int getRating(){
                return this.rating;
            }

            @Override
            public int compareTo(Food food){
                return Comparator.comparingInt(Food::getRating).reversed()
                        .thenComparing(Food::getName).compare(this, food);
            }
        }
    }
}
