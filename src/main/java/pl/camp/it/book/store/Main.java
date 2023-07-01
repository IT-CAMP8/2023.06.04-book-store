package pl.camp.it.book.store;

import pl.camp.it.book.store.model.User;

public class Main {
    public static void main(String[] args) {
        /*List<String> list = new ArrayList<>();
        list.add("Mateusz");
        list.add("Janusz");
        list.add("Karol");

        List<String> copyList = new ArrayList<>(list);
        copyList.add("Wiesiek");

        System.out.println(list);
        System.out.println(copyList);*/
        //Book book = new Book(1, "Java EE 6. Tworzenie aplikacji w NetBeans 7", "David R. Heffelfinger", 59.00, 10, "978-83-246-8936-1");
        //System.out.println(book);
        /*Book book = new Book(1, null, "David R. Heffelfinger", 59.00, 10, "978-83-246-8936-1");
        System.out.println(book);
        book.setAuthor(null);
        System.out.println(book);

        User.UserBuilder builder = User.builder();

        builder.name("Janusz");
        builder.surname("Kowalski");
        //
        //
        //
        builder.id(10);
        User user2 = builder.build();
        System.out.println(user2);

        System.out.println(user2.id());
        System.out.println(user2.name());
        System.out.println(user2.surname());
        System.out.println(user2.login());

        user2.id(7).name("Janusz").surname("Kowalski");*/

        //System.out.println(DigestUtils.md5Hex("janusz"));

        User user = new User();
        //user.setRole(User.Role.ADMIN);
    }
}
