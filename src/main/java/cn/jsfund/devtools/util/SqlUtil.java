package cn.jsfund.devtools.util;

/**
 * Created by hutx on 16:58 2018/11/22
 */
public class SqlUtil {
    public final static String ORACLE_TABLE_COLUMN_SQL = "select t.column_name,t.data_type,t.data_length,t.nullable,t1.comments ,t.column_id ," +
            " (select  count(t4.column_name) from user_constraints t3,user_cons_columns t4  where  t3.constraint_name=t4.constraint_name and t3.constraint_type='P'  and t3.table_name=upper(?) and t4.column_name =t.column_name ) as is_key " +
            "  from user_tab_columns t ,user_col_comments t1" +
            " where t.table_name = t1.table_name and t.column_name = t1.column_name  and t.table_name = upper(?)  order by column_id";
    public final static String ORACLE_TABLE_PKS_SQL = "select  t1.column_name " +
            "from user_constraints t, t.user_t._columns t1  where  t.t.traint_name=t1.t.traint_name and t.t.traint_type='P'  and col.table_name=upper(?) order by col.position";

    public final static String ORACLE_TABLE_INDEX_SQL = "select t.INDEX_NAME, dbms_lob.substr(wm_concat(t.COLUMN_NAME)) as INDEX_COLUMN  from user_ind_columns t where t.TABLE_NAME=upper(?) group by t.INDEX_NAME";

    public static String oracleTypeToJava(String type, int length) {
        switch (type) {
            case "VARCHAR2":
                return "String";
            case "NUMERIC":
                return length > 19 ? "Double" : "Long";
            case "DATE":
                return "Date";
            default:
                return "String";
        }
    }
}
