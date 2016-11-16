package com.nlte.usersys.common.util;

import com.nlte.usersys.common.exception.DaoException;
import com.nlte.usersys.usermgr.domain.DataPage;
import oracle.jdbc.OracleTypes;

import java.sql.*;

/**
 * 对Oracle数据库连接的封装工具类
 * Created by hp on 2016/11/11.
 */
public class DBUtil {
    //Oracle驱动包
    private static final String driver = "oracle.jdbc.driver.OracleDriver";
    //连接Oracle数据库的URL
    // TODO: 2016/11/11 对于数据库URL、用户名、密码可以动态输入 
    private static String url = "jdbc:oracle:thin:localhost:1521:orcl";
    //数据库用户名
    private static String username = "scott";
    //数据库密码
    private static String pwd = "tiger";

    //连接对象
    private static Connection conn = null;
    //参数语句对象
    private static PreparedStatement ps = null;

    /**
     * 获取连接对象
     *
     * @return 连接对象
     * @throws DaoException 创建对象时抛出的异常
     */
    public static Connection getConnection() throws DaoException {
        try {
            //加载驱动Oracle的jdbc驱动包
            Class.forName(driver);

            //建立连接 ：制定连接到哪里去jdbc:oracle:thin:  ip地址 : 端口号 : 服务
            conn = DriverManager.getConnection(url, username, pwd);

            if (conn != null) {
                System.out.println("连接成功");
            }
        } catch (ClassNotFoundException e) {
            throw new DaoException("驱动加载失败，请检查驱动包");
        } catch (SQLException e) {
            throw new DaoException("连接数据库服务器失败，请检查网络或相关参数");
        }
        return conn;
    }

    /**
     * 只关闭连接
     */
    public static void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭传入的连接
     *
     * @param conn 连接对象
     */
    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭指定的连接和参数语句对象
     *
     * @param conn 连接对象
     * @param ps   参数语句对象
     */
    public static void close(Connection conn, PreparedStatement ps) {

        try {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {

                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭连接和参数语句对象及结果集
     *
     * @param conn      连接对象
     * @param ps        参数语句对象
     * @param resultSet 结果集
     */
    public static void close(Connection conn, PreparedStatement ps, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭最近获得的连接和参数语句对象
     *
     * @param ps 参数语句对象
     */
    public static void close(PreparedStatement ps) {

        try {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭最近获得的连接和参数语句对象及结果集
     *
     * @param ps        参数语句对象
     * @param resultSet 结果集
     */
    public static void close(PreparedStatement ps, ResultSet resultSet) {

        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭最近获得的连接和最近参数语句对象及结果集
     *
     * @param resultSet 结果集
     */
    public static void close(ResultSet resultSet) {

        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭最近获取的连接和CallableStatement和结果集
     *
     * @param prepareCall
     * @param resultSet   结果集
     */
    public static void Close(CallableStatement prepareCall, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (prepareCall != null) {
                prepareCall.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 支持参数查询并返回结果集
     *
     * @param sql     sql语句
     * @param objects 动态参数列表
     * @return 结果集
     * @throws DaoException 创建SQL语句对象抛出的异常
     */
    // TODO: 2016/11/11 可以将sql语句拆分，通过输入参数合成SQL语句 
    public static ResultSet search(String sql, Object... objects) throws DaoException {
        Connection conn = getConnection();
        ResultSet resultSet;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                ps.setObject(i + 1, objects[i]);
            }
            resultSet = ps.executeQuery();
        } catch (SQLException e) {
            throw new DaoException("创建SQL语句对象失败");
        }
        return resultSet;
    }

    /**
     * 支持参数查询并返回一个对象
     * 类似select count(*) from emp;
     *
     * @param sql     sql语句
     * @param objects 动态参数列表
     * @return 查询到的对象
     * @throws DaoException 创建SQL语句对象抛出的异常
     */
    public static Object searchObjects(String sql, Object... objects) throws DaoException {
        Connection conn = getConnection();
        ResultSet resultSet;
        Object object = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                ps.setObject(i + 1, objects[i]);
            }
            resultSet = ps.executeQuery();
            resultSet.next();
            object = resultSet.getObject(1);
            close(ps, resultSet);
        } catch (SQLException e) {
            throw new DaoException("创建SQL语句对象失败");
        }
        return object;
    }

    /**
     * 执行插入、删除、修改等更新数据库的操作
     *
     * @param sql     SQL语句
     * @param objects 参数化对象
     * @return 影响的行数
     * @throws DaoException 创建SQL语句对象抛出的异常
     */
    // TODO: 2016/11/11 可以将增、删、改等操作分开成独立的方法，并将sql语句拆分，通过输入参数合成SQL语句 
    public static int update(String sql, Object... objects) throws DaoException {
        conn = DBUtil.getConnection();
        int rows;
        try {
            ps = conn.prepareStatement(sql);
            System.out.println("-------------------------------");
            System.out.println(objects.length);
            for (int i = 0; i < objects.length; i++) {
                ps.setObject(i + 1, objects[i]);
            }
            rows = ps.executeUpdate();
            close(ps);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException("创建SQL语句对象失败");
        }
        return rows;
    }

    /**
     * 开启事务(多用于批量数据)
     *
     * @param conn 连接对象
     * @throws DaoException 开启食物出错抛出的异常
     */
    public static void beginTransction(Connection conn) throws DaoException {
        try {
            if (conn != null) {
                conn.setAutoCommit(false);//关闭事务自动提交机制
            }
        } catch (SQLException e) {
            throw new DaoException("开启食物出错");
        }
    }

    /**
     * 提交事务
     *
     * @param conn 连接对象
     * @throws DaoException 提交食物出错抛出的异常
     */
    public static void commit(Connection conn) throws DaoException {
        try {
            if (conn != null) {
                conn.commit();
                conn.setAutoCommit(true);//恢复事务自动提交机制
            }
        } catch (SQLException e) {
            throw new DaoException("事务提交失败");
        }
    }

    /**
     * 回滚事务
     *
     * @param conn 连接对象
     * @throws DaoException 回滚食物出错抛出的异常
     */
    public static void rollback(Connection conn) throws DaoException {
        try {
            if (conn != null) {
                conn.rollback();
                conn.setAutoCommit(true);
            }
        } catch (SQLException e) {
            throw new DaoException("回滚事务失败");
        }
    }


    /**
     * @param tableName 表名，或子查询
     * @param fields    字段列表
     * @param strWhere  条件表达式
     * @param curPage   每页的记录数
     * @param pageSizes 当前页页码
     * @return 数据页对象
     * @throws DaoException 调用分页过程出错抛出的异常
     */
    public static DataPage getPage(String tableName,
                                   String fields,
                                   String strWhere,
                                   String orderFiled,
                                   int curPage,
                                   int pageSizes) throws DaoException {
        DataPage dataPage = null;
        Connection conn = getConnection();
        String sql = "call Pagination(" +
                "?," +//1、表名，或子查询
                "?," +//2、字段列表
                "?," +//3、条件表达式
                "?," +//4、排序表达式
                "?," +//5、当前页页码
                "?," +//6、每页的记录数
                "?," +//7、总记录数   -- 输出参数
                "?," +//8、总页数，或页数（存储过程计算出来）-- 输出参数
                "?)";// 9、当前页的数据 --输出参数
        try {
            //创建存储过程
            CallableStatement prepareCall = conn.prepareCall(sql);

            int i = 1;
            //给存储过程的参数设置值
            prepareCall.setString(i++, tableName);
            prepareCall.setString(i++, fields);
            prepareCall.setString(i++, strWhere);
            prepareCall.setString(i++, orderFiled);
            prepareCall.setInt(i++, curPage);
            prepareCall.setInt(i++, pageSizes);
            //注册输出参数
            /*All OUT parameters must be registered before a stored procedure is executed.*/
            prepareCall.registerOutParameter(i++, Types.INTEGER);//总记录数
            prepareCall.registerOutParameter(i++, Types.INTEGER);//总页数
            prepareCall.registerOutParameter(i++, OracleTypes.CURSOR);////当前页的数据

            prepareCall.execute();//执行存储过程

            dataPage = new DataPage();

            //执行完后，获取输出参数
            //获取总记录数
            int totalRows = prepareCall.getInt(7);
            dataPage.setTotalRows(totalRows);

            //获取总页数
            int pages = prepareCall.getInt(8);
            dataPage.setPages(pages);

            //获取当前页的数据
            ResultSet resultSet = (ResultSet) prepareCall.getObject(9);

            dataPage.setData(resultSet);

            //close(prepareCall, resultSet);
        } catch (SQLException e) {
            throw new DaoException("调用分页过程出错");
        }
        return dataPage;
    }
}
