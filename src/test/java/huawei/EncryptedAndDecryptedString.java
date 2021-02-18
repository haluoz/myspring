package huawei;


import java.util.Scanner;

public class EncryptedAndDecryptedString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String input = sc.nextLine();
            String output = sc.nextLine();
            char[] inputs = input.toCharArray();
            char[] outputs = output.toCharArray();
            StringBuilder inBuilder = new StringBuilder();
            StringBuilder outBuilder = new StringBuilder();
            for (char c :inputs) {
                inBuilder.append(encrypt(c));
            }
            for (char c :outputs) {
                outBuilder.append(decrypt(c));
            }
            System.out.println(inBuilder.toString());
            System.out.println(outBuilder.toString());
        }
    }



    public static char encrypt(char c){
        if(c >= 'a' && c < 'z')
            return (char)(c + 1 - 32);
        else if(c == 'z')
            return 'A';
        else if(c >= 'A' && c < 'Z')
            return (char)(c + 1 + 32);
        else if(c == 'Z')
            return 'a';
        else if(c >= '0' && c < '9')
            return (char)(c + 1);
        else if(c == '9')
            return '0';
        else {
            return c;
        }
    }

    public static char decrypt(char c){
        if(c > 'a' && c <= 'z')
            return (char)(c - 1 - 32);
        else if(c == 'a')
            return 'Z';
        else if(c > 'A' && c <= 'Z')
            return (char)(c - 1 + 32);
        else if(c == 'A')
            return 'z';
        else if(c > '0' && c <= '9')
            return (char)(c - 1);
        else if(c == '0')
            return '9';
        else {
            return c;
        }
    }

}
