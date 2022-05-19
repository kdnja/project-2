import java.util.ArrayList;

/*
 * Problem 2 Sell My Pet Food
 */
public class TargetedAd {

    public static void main(String[] args) {

        // Create a new DataCollector object
        DataCollector dataCollector = new DataCollector();
        // Set the data to "socialMediaPostsSmall.txt" and "targetWords.txt"
        dataCollector.setData("socialMediaPosts.txt", "targetWords.txt");

        // Store target words, social media posts, and users in their own respective ArrayLists
        ArrayList<String> targetWords = dataCollector.getTargetWords();
        ArrayList<String> socialMediaPosts = dataCollector.getSocialMediaPosts();
        ArrayList<String> users = new ArrayList<String>();

        // Iterate through the social media posts
        for (int i = 0; i < socialMediaPosts.size(); i++) {
            // Get info and separate it into post and user
            String curInfo = socialMediaPosts.get(i);
            String curUser = curInfo.substring(0, curInfo.indexOf(" "));
            String curPost = curInfo.substring(curInfo.indexOf(" "));
            // Iterate through the target words
            for (int j = 0; j < targetWords.size(); j++) {
                // Get current target word
                String curTarget = targetWords.get(j);
                // If the post includes the target word, and the user list doesn't include the user
                if (curPost.indexOf(curTarget) != -1 && !users.contains(curUser)) {
                    // Add the user to the list
                    users.add(curUser);
                }
            }
        }

        // Prepares the advertisement
        dataCollector.prepareAdvertisement("advertisement.txt", users,
                "We bet your furry friend would love to smell our pet food!");

    }

}
