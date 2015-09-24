package ejb;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-08-20T00:22:22")
@StaticMetamodel(CustomerOrderLine.class)
public class CustomerOrderLine_ { 

    public static volatile SingularAttribute<CustomerOrderLine, Long> id;
    public static volatile SingularAttribute<CustomerOrderLine, Double> amount;
    public static volatile SingularAttribute<CustomerOrderLine, String> orderNo;
    public static volatile SingularAttribute<CustomerOrderLine, String> partNo;
    public static volatile SingularAttribute<CustomerOrderLine, Integer> lineNo;

}