import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava {
    public ArrayList<Integer> getTenRolls(){
        ArrayList<Integer> listOfNums = new ArrayList<Integer>();
        Random randomNum = new Random();
        for (int i=0; i < 10; i++ ){ 
            int randomInt = randomNum.nextInt(21);
            listOfNums.add(randomInt);
        }
        return listOfNums;
    }

    public char getRandomLetter(){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char myArray [] = alphabet.toCharArray();
        Random randIndex = new Random();
        int index = randIndex.nextInt(26);
        return myArray[index];
    }
    public String generatePassword(){
        String password = "";
        for (int i =0; i<8; i++ ){
            password+= getRandomLetter();
        }
        return password;
        }
    
    public ArrayList<String> generatePasswordSet(int n){
            ArrayList<String> passwordArray = new ArrayList<String>();
            for (int j =0; j<n; j++ ){
                passwordArray.add(generatePassword()); 
            }
            return passwordArray;
            }
}