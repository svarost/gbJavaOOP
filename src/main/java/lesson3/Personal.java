package lesson3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Personal implements Iterable<User> {

    private User[] users;

    public Personal(User[] users) {
        this.users = users;
        users.getClass();
    }

    @Override
    public Iterator<User> iterator() {
        return null;
    }

    protected class PersonalIterator implements Iterator<User> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < users.length;
        }

        @Override
        public User next() {
            return users[index++];
        }
    }
}

