package models.specs;

import org.springframework.data.jpa.domain.Specification;

import models.Patient;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@And({
    @Spec(path="firstName",params="firstName",spec=LikeIgnoreCase.class),
    @Spec(path="lastName",params="lastName",spec=LikeIgnoreCase.class),
    @Spec(path="middleName",params="middleName",spec=LikeIgnoreCase.class),
    @Spec(path="phoneNumber",params="phoneNumber",spec=LikeIgnoreCase.class),
    @Spec(path="email",params="email",spec=LikeIgnoreCase.class),
    @Spec(path="country",params="country",spec=Equal.class),
    @Spec(path="gender",params="gender",spec=Equal.class),
    @Spec(path="dateOfBirth", params="dateOfBirth", spec=Equal.class)
})
public interface PatientSpec extends Specification<Patient>{
}