package ejb;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-08-20T00:22:22")
@StaticMetamodel(CustomerOrder.class)
public class CustomerOrder_ { 

    public static volatile SingularAttribute<CustomerOrder, Long> id;
    public static volatile SingularAttribute<CustomerOrder, Double> amount;
    public static volatile SingularAttribute<CustomerOrder, String> orderNo;
    public static volatile SingularAttribute<CustomerOrder, String> customerid;
    public static volatile SingularAttribute<CustomerOrder, String> name;
    public static volatile SingularAttribute<CustomerOrder, String> comment;
    public static volatile SingularAttribute<CustomerOrder, Date> dueDate;

}