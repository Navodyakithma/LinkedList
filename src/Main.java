import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                ArrayList<Integer> listArray =  new ArrayList<Integer>();
                int i = 0;

                while(i < 5){
                    System.out.print("Enter Your Value : ");
                    int value = scanner.nextInt();

                    listArray.add(value);
                    i++;
                }


                LinkedList ob1= new LinkedList();
                i = 0;

                while(listArray.size() > i){
                    ob1.addValues(listArray.get(i));
                    i++;
                }

                ob1.traverse();



            }


        }

        class Node{
            Node previous;
            Node next;


            int data;

            public Node(int data){
                this.data = data;

            }

        }

        class LinkedList{

            Node first;

            public void addValues(int data1){
                Node node = new Node(data1);

                if(first == null){
                    first = node;
                }else{
                    Node current = first;
                    Node previous = current;
                    int getValue = -1;

                    while(current != null && current.data < data1){
                        previous = current;


                        current = current.next;
                        getValue = 0;

                        if(previous.next == null){
                            getValue = 1;
                            break;
                        }


                    }

                    if(getValue == 0){

                        previous.next = node;
                        node.next = current;
                        node.previous = previous;
                        current.previous = node;

                    }else if(getValue == 1){
                        previous.next = node;
                        node.previous = node;

                    }else if(getValue == -1){
                        first.previous = node;
                        node.next = first;
                        first = node;
                    }
                }


            }

            public void remove(int value){
                Node current = first;
                Node previous = current;

                while(current != null){
                    if(current.data == value){
                        break;

                    }
                    previous = current;
                    current = current.next;
                }

                previous.next = current.next;


            }

            public void traverse(){
                Node current = first;

                while(current != null){
                    System.out.println(current.data);
                    current = current.next;
                }


            }


        }

