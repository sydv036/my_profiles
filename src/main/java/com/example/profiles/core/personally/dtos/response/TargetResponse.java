package com.example.profiles.core.personally.dtos.response;

import com.example.profiles.entity.Target;
import com.example.profiles.entity.TargetAccount;
import com.example.profiles.entity.TargetType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = {Target.class, TargetAccount.class, TargetType.class})
public interface TargetResponse {
    String getTargetID();

    String getTargetName();

    String getTargetTypeID();

    String getTargetTypeName();

}
