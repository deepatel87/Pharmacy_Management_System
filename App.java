import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
class App{
    static Scanner sc=new Scanner(System.in);
    static Statement st ;
    static Connection con;
    public static void main(String[] args) throws Exception {               // main method
        String dburl="jdbc:mysql://localhost:3306/medical";
        String dbuser="root";
        String dbpass="";
        String driver="com.mysql.cj.jdbc.Driver";
        Class.forName(driver);
        con=DriverManager.getConnection(dburl,dbuser,dbpass);
        if(con!=null){
            System.out.println("connection successful");
        }
        else{
            System.out.println("Connection failed");
        }

        String sql="Create table if not exists Pharmacy(sr_no int(255) primary key auto_increment,name varchar(30),category varchar(20),exp_date Date,quantity int(30),price decimal(10,2))";
        st=con.createStatement();
        st.executeUpdate(sql);
        int n=1;
        while(n!=0){
            System.out.println("Enter [1] to add medicine in database \nEnter [2] to delete Medicine from database \nEnter [3] to display medicines \nEnter [4] to Update price of medicine \nEnter [5] to Update Quantity of the medicine \nEnter [6] to update expiry date \nEnter [7] to serach Medicine \nEnter [8] to make bill");
            int s=sc.nextInt();
            switch (s) {
                case 1:add();

                    break;
                case 2:delete();

                    break;
                case 3:display();

                    break;
                case 4:updatePrice();

                    break;
                case 5:updateQuantity();

                    break;
                case 6:updateDate();

                    break;
                case 7:serach();

                    break;
                case 8: Bill();

                    break;
                default:System.out.println("enter valid number from above");
                    break;
            }
        }
    }

    static void add()throws Exception{                           //to add product in database 
        sc.nextLine() ;
        System.out.println("Enter the name of the medicine");
        String name=sc.nextLine();

        System.out.println("Enter the category of the medicine");
        String category=sc.nextLine();

        System.out.println("Enter the expiry date of the medicine");
        System.out.println();
        System.out.println("enter the year in '2023' form");
        int year=sc.nextInt();
        System.out.println("enter the month in '01' or'11'  form");
        int month=sc.nextInt();
        System.out.println("enter the date in '01' or '20' form");
        int day=sc.nextInt();


        System.out.println("Enter the quantity of the medicine ");
        int quantity=sc.nextInt();

        System.out.println("Enter the price of the medicine");
        double price=sc.nextDouble();

        String add="insert into pharmacy (name,category,exp_date,quantity,price)values(?,?,'"+year+"-"+month+"-"+day+"',?,?)";
        PreparedStatement pst=con.prepareStatement(add);
        pst.setString(1, name);
        pst.setString(2, category);
        pst.setInt(3, quantity);
        pst.setDouble(4, price);
        pst.executeUpdate();
    }

    public static void delete() throws Exception{                                      // to delete product from database by ID
        System.out.println("enter the Medicine ID of the medicine you want to delete");
        int medidcine_id=sc.nextInt();
        String del="Delete from pharmacy where sr_no=  "+medidcine_id;
        int r = st.executeUpdate(del) ;
        if(r==1){
            System.out.println("DELETION SUCCESSFULL");
        }else{
            System.out.println("NO SUCH PRODUCT FOUND");
        }
    }

    static void updateDate()throws Exception{                                       //to update expiry date of the product by ID
        System.out.println("enter the Medicine ID of the medicine you want to update");
        int ID=sc.nextInt();
        System.out.println("Enter the expiry date of the medicine");
        System.out.println();
        System.out.println("enter the year in '2023' form");
        int year=sc.nextInt();
        System.out.println("enter the month in '01' or'11'  form");
        int month=sc.nextInt();
        System.out.println("enter the date in '01' or '20' form");
        int day=sc.nextInt();
        String new_quantity="update pharmacy set exp_date = '"+year+"-"+month+"-"+day+"' where sr_no ="+ID;
        Statement s=con.createStatement();
        s.executeUpdate(new_quantity);
    }

    static void updateQuantity()throws Exception{                                       // to update Quantity of the product by ID
        System.out.println("enter the Medicine ID of the medicine you want to update");
        int ID=sc.nextInt();
        System.out.println("enter new Quantity");
        int newQuantity=sc.nextInt();
        String new_quantity="update pharmacy set quantity = '"+newQuantity+"' where sr_no ="+ID;
        Statement s=con.createStatement();
        s.executeUpdate(new_quantity);
    }

    static void updatePrice()throws Exception{                                         //to update price of the product by ID
        System.out.println("enter the Medicine ID of the medicine you want to price");
        int ID=sc.nextInt();
        System.out.println("enter new Quantity");
        double newPrice=sc.nextDouble();
        String new_price="update pharmacy set price = '"+newPrice+"' where sr_no ="+ID;
        Statement s=con.createStatement();
        s.executeUpdate(new_price);
    }

    static void Bill()throws Exception{                               // to make bill and store in txt file
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the nane of the customer");
        String customer=sc.nextLine();
        int o=1;
        String phoneNo="";
        while(o!=0){
            System.out.println("Enter the phone no. of employee");
            String ph=sc.nextLine();
            if(ph.length()==10){
                phoneNo=ph;
                o=0;
            }else{
                System.out.println("Enter 10 digit no. ");
            }
        }
        System.out.println("Enter the E-mail of the customer");
        String email=sc.nextLine();
        ArrayList<Integer> id = new ArrayList<>() ;

        ResultSet rs = st.executeQuery("select * from pharmacy" );
        while (rs.next()){
            System.out.println("==============================================================================================");
            System.out.println("Product Name : " +rs.getString(2));
            System.out.println("Product Id : " +rs.getInt(1));
            System.out.println("Expiry Date : " +rs.getDate("exp_date").toString());
            System.out.println("Price  : " + rs.getDouble(6));
            id.add(rs.getInt(1)) ;
        }

        File f=new File("C://Bill/"+customer+".txt");
        FileWriter fw=new FileWriter(f,false);
        BufferedWriter bw=new BufferedWriter(fw);
        bw.write("Name:- "+customer);
        bw.newLine();
        bw.write("phone no. :- "+phoneNo);
        bw.newLine();
        bw.write("e-mail ID :- "+email);
        bw.newLine();
        bw.write("------------------------------------------------------------------------------------------------");
        bw.newLine();
        bw.write("--------------------MEDICINE DETAILS--------------------------");
        bw.newLine();


        boolean flag = false ;
        double total = 0.0 ;


        while (true){
            System.out.println("PRESS [1] TO ADD MEDICINE\nPRESS [2] TO GENERATE BILL AND EXIT");
            int choice = getInt();
            while (choice!=1 && choice!=2){
                System.out.println("ENTER AGAIN");
                choice=getInt() ;
            }
            if(choice==1){
                System.out.println("ENTER MEDICINE ID :");
                int med_id= getInt() ;
                if(id.contains(med_id)){
                    System.out.println("ENTER QUANTITY");
                    int quan = getInt() ;
                    rs = st.executeQuery("select * from pharmacy where sr_no = " + med_id );
                    rs.next() ;
                    if(quan>rs.getInt(5)){
                        System.out.println("STOCK UNAVAILABLE");
                    } else {
                        flag = true ;
                        bw.write("NAME : " + rs.getString("name"));
                        bw.newLine();
                        bw.write("PRICE : " + rs.getDouble("price"));
                        bw.newLine();
                        bw.write("CATEGORY : " + rs.getString("category"));
                        bw.newLine();
                        bw.write("EXPIRY DATE : " + rs.getDate("exp_date").toString());
                        bw.newLine();
                        bw.write("QUANTITY : " + quan);
                        bw.newLine();
                        bw.write("-------------------------------------------------------------------------------------------------------");
                        bw.newLine();
                        total+=quan*rs.getDouble("price") ;
                        st.executeUpdate("update pharmacy set quantity = quantity - " + quan +" where sr_no = " + med_id ) ;
                    }
                }
            }else{
                if(!flag){
                    System.out.println("CANNOT GENERATE BILL AS NO MEDICINE HAS BEEN ADDED");
                    return;
                } else {
                    bw.write("THE TOTAL COST MEDICINE IS : " + total);
                    bw.newLine();
                    bw.flush();
                    id.clear();
                    System.out.println("BILL HAS BEEN GENERATED SUCCESSFULLY");
                    return;
                }
            }
        }
    }
    public static int getInt() {
        while(true){
            try{
                int s = sc.nextInt();
                return s;
            }catch(Exception e){
                System.out.println("INVALID INPUT ");
                sc.nextLine();
            }
        }
    }

    public static void serach()throws Exception{                                //to search product by name 
        sc.nextLine() ;
        System.out.println("Enter the Name of the Medicine");
        String med=sc.nextLine();
        String sql2="select * from pharmacy where name='"+med+"'";
        Statement s=con.createStatement();
        ResultSet rs=s.executeQuery(sql2);
        if(!rs.next()){
            System.out.println("Not found");
        }
        else{
            do {
                System.out.println("Name :- "+rs.getString(2));
                System.out.println("Category :- "+rs.getString(3));
                System.out.println("Expiry date:-"+rs.getDate(4));
                System.out.println("Quantity :- "+rs.getInt(5));
                System.out.println("Price :- "+rs.getDouble(6));
            } while (rs.next());
        }

    }

    public static void display()throws Exception{                          //to display all the products 
        ResultSet rs = st.executeQuery("select * from pharmacy" );
        while (rs.next()){
            System.out.println("==============================================================================================");
            System.out.println("Product Name : " +rs.getString(2));
            System.out.println("Product Id : " +rs.getInt(1));
            System.out.println("Expiry Date : " +rs.getDate("exp_date").toString());
            System.out.println("Price  : " + rs.getDouble(6));
        }
    }
}