package in.scalive.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer empId;
  @NotBlank(message="Emmployee name is required!")
	private	String ename;
	
	@NotNull(message="Salary is required!")
	@Min(value=10000, message="Salary must be atleast 100000")
	private	Double sal;
}
