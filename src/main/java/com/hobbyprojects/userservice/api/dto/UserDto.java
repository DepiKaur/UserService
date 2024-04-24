package com.hobbyprojects.userservice.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hobbyprojects.userservice.constants.AppConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

/**
 * @author Depinder Kaur
 * @version 0.1
 * <h2>UserDto</h2>
 * @date 2024-04-02
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

        @JsonProperty(value = "firstname")
        @Schema(name = "firstname", example = "Anna", required = true)
        @NotEmpty(message = "First name can not be null or empty")
        private String firstName;

        @JsonProperty(value = "lastname")
        @Schema(name = "lastname", example = "Svensson", required = true)
        @NotEmpty(message = "Last name can not be null or empty")
        private String lastName;

        @JsonProperty(value = "email")
        @Schema(name = "email", example = "test@gmail.com", required = true)
        @Pattern(regexp = AppConstants.EMAIL_REGEX, message = "Email must be valid")
        private String email;

        @JsonProperty(value = "creation_date")
        @CreationTimestamp          // another similar hibernate annotation is @UpdateTimestamp
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
        private LocalDateTime creationDate;
}
