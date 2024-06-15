package uptc.frw.vueltaCiclismo.jpa.entity;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Map;

@Document(collection = "audit_transaction")
public class AuditTransaction {
    @Id
    private String id;
    @Field(name = "action")
    private String action;
    @Field(name = "table")
    private String table;
    @Field(name = "data")
    private Map<String,Object> data;

    public AuditTransaction() {
    }

    public AuditTransaction(String id, String action, String table, Map<String, Object> data) {
        this.id = id;
        this.action = action;
        this.table = table;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "AuditTransaction{" +
                "id='" + id + '\'' +
                ", action='" + action + '\'' +
                ", table='" + table + '\'' +
                ", data=" + data +
                '}';
    }
}