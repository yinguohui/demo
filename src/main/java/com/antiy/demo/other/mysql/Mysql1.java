package com.antiy.demo.other.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author ygh
 * @Description
 * @Date 2019/11/11
 */
public class Mysql1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

//        Class.forName("com.mysql.jdbc.Driver");
//        String url = "jdbc:mysql://localhost:3306/ygh?serverTimezone=UTC";
//        String user = "root";
//        String pass = "root";
//        Connection conn = DriverManager.getConnection(url,user,pass);
//        Statement statement = conn.createStatement();
//        String test = "SELECT a.* FROM `baseline_config_info` a JOIN (SELECT id FROM `baseline_config_info` limit 0,10000) b on a.id=b.id";
//        String testsql = "REPLACE INTO `baseline_config_info`(`id`, `name`, `rule_id`, `level`, `cpe`, `source`, `description`, `basis`, `fix_content`, `fix_id`, `effect`, `check_script`, `fix_script`, `suggest`, `remark`, `gmt_modified`, `gmt_create`, `gmt_create_date`, `create_user`, `modified_user`, `status`, `os`) VALUES (56, '所有人匿名权利11111', 'COMMON-2019-0225', 2, null, 3, '不能将系统配置为授予匿名用户Everyone权限', '检查结果是否等于0', '修改注册表值', null, '可能造成安全隐患', 'reg query \\\"HKEY_LOCAL_MACHINE\\\\\\\\System\\\\\\\\CurrentControlSet\\\\\\\\Control\\\\\\\\Lsa\\\" /v everyoneincludesanonymous|find \\\"everyoneincludesanonymous\\\"', 'reg add \\\"HKEY_LOCAL_MACHINE\\\\\\\\System\\\\\\\\CurrentControlSet\\\\\\\\Control\\\\\\\\Lsa\\\" /v everyoneincludesanonymous /d 1 /f', 'dsadasdsa', '', 1573111219000, 1573111216000, null, '0', '0', 1, 1)";
//        String testsql2 = "REPLACE INTO `baseline_config_info`(`id`, `name`, `rule_id`, `level`, `cpe`, `source`, `description`, `basis`, `fix_content`, `fix_id`, `effect`, `check_script`, `fix_script`, `suggest`, `remark`, `gmt_modified`, `gmt_create`, `gmt_create_date`, `create_user`, `modified_user`, `status`, `os`) VALUES (56, '所有人匿名权利11111', 'COMMON-2019-0225', 2, null, 3, '不能将系统配置为授予匿名用户Everyone权限', '检查结果是否等于0', '修改注册表值', null, '可能造成安全隐患', 'reg query \\\"HKEY_LOCAL_MACHINE\\\\\\\\System\\\\\\\\CurrentControlSet\\\\\\\\Control\\\\\\\\Lsa\\\" /v everyoneincludesanonymous|find \\\"everyoneincludesanonymous\\\"', 'reg add \\\"HKEY_LOCAL_MACHINE\\\\\\\\System\\\\\\\\CurrentControlSet\\\\\\\\Control\\\\\\\\Lsa\\\" /v everyoneincludesanonymous /d 1 /f', 'dsadasdsa', '', 1573111219000, 1573111216000, null, '0', '0', 1, 1)";
//        statement.addBatch(testsql);
//        statement.addBatch(testsql2);
//        statement.executeBatch();
        char b = 'v';
        char c = (char) (b - 32);
        System.out.println(c);
        System.out.println((char) 32);
    }
}
