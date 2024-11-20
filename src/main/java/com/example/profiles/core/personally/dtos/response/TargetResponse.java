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

//@Projection(types = {Target.class, TargetAccount.class, TargetType.class})
//public interface TargetResponse {
//    //From Entity Target
//    @Value("#{target.id}")
//    String getTargetID();
//
//    //From Entity Target
//    @Value("#{target.targetName}")
//    String getTargetName();
//
//    //From Entity TargetType
//    @Value("#{target.id}")
//    String getTargetTypeID();
//
//    //From Entity TargetType
//    @Value("#{target.targetTypeName}")
//    String getTargetTypeName();
//
//}

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TargetResponse {
    private String targetID;
    private String targetName;
    private String targetTypeID;
    private int targetTypeName;
}
