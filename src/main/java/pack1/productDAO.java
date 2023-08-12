/*package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class productDAO {

	
	private String jdbcURL="jdbc:mysql://localhost:3306/ecommerce?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword= "root";
    
    
    private static final String INSERT_PRODUCT_SQL = "INSERT INTO product"+"(ProductName, SupplierID, CategoryID, Quantity, UnitPrice)VALUES"
    +"(?,?,?,?,?);";
    
    private static final String SELECT_PRODUCT_BY_ID = "select ProductName,Quantity, UnitPrice where id=?;";
    private static final String SELECT_ALL_PRODUCT = "select * from product;";
    private static final String DELETE_PRODUCT_SQL = "select from product where id=?;";
    private static final String UPDATE_PRODUCT_SQL = "update product set  ProductName=?, SupplierID=?, CategoryID=?, Quantity=?, UnitPriceid=? where Pid=?;";
    
    
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public void insertProduct(product product) throws SQLException {
        System.out.println(INSERT_PRODUCT_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL)) {
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setInt(2, product.getSupplierID());
            preparedStatement.setInt(3, product.getCategoryID());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.setInt(5, product.getUnitPrice());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public product selectProduct(int Pid) {
        product product= null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);) {
            preparedStatement.setInt(1, Pid);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String ProductName = rs.getString("ProductName");
                int Quantity= rs.getInt("Quantity");
                int UnitPrice= rs.getInt("UnitPrice");
                product = new product(ProductName, Quantity, UnitPrice);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return product;
    }

    public List<product> selectAllProducts() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<product> products = new ArrayList<>();
    	// Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int Pid = rs.getInt("Pid");
                String ProductName = rs.getString("ProductName");
                int SupplierID = rs.getInt("SupplierID");
                int  CategoryID= rs.getInt("CategoryID");
                int  Quantity= rs.getInt("Quantity");
                int  UnitPrice= rs.getInt("UnitPrice");
                products.add(new product(Pid, ProductName, SupplierID, CategoryID, Quantity, UnitPrice));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return products;
    }

    public boolean deleteProduct(int Pid) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_SQL);) {
            statement.setInt(1, Pid);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateProduct(product product) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT_SQL);) {
            statement.setString(1,  product.getProductName());
            statement.setInt(2,  product.getSupplierID());
            statement.setInt(3,  product.getCategoryID());
            statement.setInt(4,  product.getQuantity());
            statement.setInt(5,  product.getUnitPrice());
            statement.setInt(6,    product.getPid());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
*/