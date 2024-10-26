public class Main {

  public static void main(String[] args) {

    StringList stringList=new CustomList() ;
    stringList.add(0, "one");
    stringList.add(1, "two");
    stringList.add(2,"three");
    stringList.add(3,"four");
    stringList.add(4,"five");
    stringList.add(5,"six");
    stringList.add(6,"seven");
    System.out.println(stringList);
    stringList.set(0,"zero");
    System.out.println(stringList);
    stringList.remove("two");
    System.out.println(stringList);
    stringList.remove(0);
    System.out.println(stringList);

    System.out.println(stringList.contains("eight"));
    System.out.println(stringList.indexOf("three"));
    System.out.println(stringList.lastIndexOf("seven"));
    System.out.println(stringList.get(3));
    System.out.println(stringList.equals(stringList));
    System.out.println(stringList.size());
    System.out.println(stringList.isEmpty());
    stringList.clear();
    System.out.println(stringList);
    stringList.toArray();
    System.out.println(stringList);







}
}
