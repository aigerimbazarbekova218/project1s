import company.model.User;
import company.model.enums.Gender;
import company.service.UserService;
import company.service.impl.MyException;
import company.service.impl.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        User user1=new User(1,"Aigerim",25, Gender.FEMALE);
        User user2=new User(2,"Amantur",27,Gender.MALE);
        User user3=new User(3,"Aisuluu",23,Gender.FEMALE);

        UserService userService=new UserServiceImpl();
        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        System.out.println(userService.getAllUsers());

        try{
            System.out.println(userService.getById(1));
            userService.delete(8);
        }catch (RuntimeException | MyException e){
            System.out.println(e.getMessage());
        }
        System.out.println("___________________________");
        System.out.println(userService.getAllUsers());
    }
}