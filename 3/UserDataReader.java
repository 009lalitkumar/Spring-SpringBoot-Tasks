import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class UserDataReader {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new FileReader("user_data.xml"))) {
            UserBean bean = UserBean.getInstance();
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.equalsIgnoreCase("<first_name>")) {
                    bean.setFirstName(sc.nextLine().trim());
                }
                if (line.equalsIgnoreCase("<last_name>")) {
                    bean.setLastName(sc.nextLine().trim());
                }
            }
            System.out.println(bean);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
