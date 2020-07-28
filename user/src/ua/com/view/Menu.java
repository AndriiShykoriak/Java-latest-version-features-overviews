package ua.com.view;

import ua.com.model.User;
import ua.com.service.UserService;
import ua.com.service.impl.UserServiceImpl;

import java.util.Scanner;

public class Menu {
    private UserService userService = UserServiceImpl.getInstance();
    private Scanner scanner = new Scanner(System.in);
    private String[] menu = {"1-Add user", "2-Edit user", "3-Delete user", "4-FindByAll users", "5-Exit"};

    public void start() {
        loop:
        while (true) {
            showMenu(menu);
            int count = scanner.nextInt();
            switch (count) {
                case 1 -> addUser();
                case 2 -> editUser();
                case 3 -> deleteUser();
                case 4 -> findByAll();
                case 5 -> {
                    break loop;
                }
            }
        }
    }

    private void showMenu(String[] menu) {
        for (String s : menu) {
            System.out.println(s);
        }
    }

    private void addUser() {
        System.out.println("Input name");
        User user = new User();
        user.setName(scanner.next());
        System.out.println("Input Surname");
        user.setSurname(scanner.next());
        System.out.println("Input age");
        user.setAge(scanner.nextInt());
        userService.create(user);
        System.out.println("Saved");
    }

    private void editUser() {
        System.out.println("enter id:");
        User user = userService.findById(scanner.nextInt());
        if (user != null) {
            System.out.println("Enter the name " + user.getName());
            user.setName(scanner.next());
            System.out.println("Enter the surname " + user.getSurname());
            user.setSurname(scanner.next());
            System.out.println("Enter the age " + user.getAge());
            user.setAge(scanner.nextInt());
            userService.update(user);
            System.out.println("User " + user.getName() + user.getSurname() + user.getAge() + " updated");
        } else {
            System.out.println("User does not exist");
        }
    }

    private void deleteUser() {
        System.out.println("enter id:");
        User user = userService.findById(scanner.nextInt());
        if (user != null) {
            userService.delete(user);
            System.out.println("Deleted");
        } else {
            System.out.println("User does not exist");
        }
    }

    private void findByAll() {
        userService.findAll().forEach(System.out::println);
    }
}
