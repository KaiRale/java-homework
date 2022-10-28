package hm14.message;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MessageTask {

    public static void main(String[] args) {
        List<Message> messages = Message.generate(10);
        System.out.println(messages);

        countEachPriority(messages);
        countEachCode(messages);
        uniqueMessageCount(messages);
        System.out.println(uniqueMessagesInOriginalOrder(messages));
        removeEach(messages, MessagePriority.HIGH);
        removeOther(messages, MessagePriority.HIGH);
    }

    public static void countEachPriority(List<Message> messageList) {
        // TODO:  Подсчитать количество сообщений для каждого приоритета
        //  Ответ в консоль
        for (MessagePriority priority : MessagePriority.values()) {
            int i = 0;
            for (Message message : messageList) {
                if (message.getPriority() == priority) i++;
            }
            System.out.println("Messages quantity for " + priority.name() + " priority is " + i);
        }
    }

    public static void countEachCode(List<Message> messageList) {
        // TODO: Подсчитать количество сообщений для каждого кода сообщения
        //  Ответ в консоль

        for (int i = 0; i < 10; i++) {
            int j = 0;
            for (Message message : messageList) {
                if (message.getCode() == i) {
                    j++;
                }
            }
            System.out.println("Messages quantity for " + i + " code is " + j);
        }
    }

    public static void uniqueMessageCount(List<Message> messageList) {
        // TODO: Подсчитать количество уникальных сообщений
        //  Ответ в консоль
        int i = 0;
        for (Message message : messageList) {
            if (messageList.indexOf(message) == messageList.lastIndexOf(message)) i++;
        }
        System.out.println("Quantity of unique messages is " + i);
    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList) {
        // TODO: вернуть только неповторяющиеся сообщения и в том порядке,
        //  в котором они встретились в первоначальном списке
        //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]
        List<Message> uniqueList = new ArrayList<>();

        for (Message message : messageList) {
            if (messageList.indexOf(message) == messageList.lastIndexOf(message)) uniqueList.add(message);
        }

        return uniqueList;
    }

    public static void removeEach(List<Message> messageList, MessagePriority priority) {
        // TODO: удалить из коллекции каждое сообщение с заданным приоритетом
        //  вывод в консоль до удаления и после удаления
        Iterator<Message> iterator = messageList.iterator();
        System.out.println("Before remove: \n" + messageList);

        while (iterator.hasNext()) {
            if (iterator.next().getPriority() == priority) {
                iterator.remove();
            }
        }

        System.out.println("After remove: \n" + messageList);
    }

    public static void removeOther(List<Message> messageList, MessagePriority priority) {
        // TODO: удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет
        //  вывод в консоль до удаления и после удаления
        Iterator<Message> iterator = messageList.iterator();
        System.out.println("Before remove: \n" + messageList);

        while (iterator.hasNext()) {
            if (iterator.next().getPriority() != priority) {
                iterator.remove();
            }
        }

        System.out.println("After remove: \n" + messageList);
    }

}
