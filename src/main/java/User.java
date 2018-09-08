import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author daixunan
 * @date 2018/9/8
 */

@Data
@ToString
@AllArgsConstructor
public class User {
    private String id;
    private String name;
    private int age;
}
