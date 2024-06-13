# Serialize and Deserialize object Json in Java
## Serialize Object to Json
### Steps
1. Create a class that you want to serialize to Json
2. Create a Gson object
3. Call toJson() method of Gson object and pass the object to be serialized
4. The toJson() method will return the Json string
5. Print the Json string

```java
import com.google.gson.Gson;

class Employee {
    private String name;
    private int age;
    private String department;

    public Employee(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }
}

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("John", 30, "IT");
        Gson gson = new Gson();
        String json = gson.toJson(employee);
        System.out.println(json);
    }
}
```

La salida será:
```
{"name":"John","age":30,"department":"IT"}
```



## Deserialize Json to Object
### Steps
1. Create a class that you want to deserialize from Json
2. Create a Gson object
3. Call fromJson() method of Gson object and pass the Json string and the class type
4. The fromJson() method will return the object
5. Print the object

```java
import com.google.gson.Gson;

class Employee {
    private String name;
    private int age;
    private String department;

    public Employee(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }
}

public class Main {
    public static void main(String[] args) {
        String json = "{\"name\":\"John\",\"age\":30,\"department\":\"IT\"}";
        Gson gson = new Gson();
        Employee employee = gson.fromJson(json, Employee.class);
        System.out.println(employee.getName());
        System.out.println(employee.getAge());
        System.out.println(employee.getDepartment());
    }
}
```
La salida será:
```java
John
30
IT
```
