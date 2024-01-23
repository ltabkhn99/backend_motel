package vn.oceantech.l3pre.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class EnumType {
    @Getter
    @AllArgsConstructor
    public enum ROLE {
        ROLE_LEADER(1, "ROLE_LEADER"),
        ROLE_MANAGER(2, "ROLE_MANAGER");
        private final int id;
        private final String name;
    }

    @Getter
    @AllArgsConstructor
    public enum EMPLOYEE_STATUS {
        NEW(1, "NEW"),
        PENDING(2, "PENDING"),
        APPROVED(3, "APPROVED"),
        REJECT(4, "REJECT"),
        ENDED(5, "ENDED"),
        SAVED(6, "SAVED"),
        ADDITIONAL_REQUEST(7, "ADDITIONAL_REQUEST"),
        PENDING_SALARY_INCREMENT(13, "Waiting for approval of salary increment profile"),
        PENDING_PROMOTION(14, "Waiting for approval of promotion application"),
        PENDING_PROPOSAL(15, "Waiting for approval of proposal profile");
        private final int id;
        private final String name;
    }

    @Getter
    @AllArgsConstructor
    public enum PROFILE_STATUS {
        NEW(8, "NEW_PROFILE"),
        PENDING(9, "PENDING_PROFILE"),
        ADDITIONAL_REQUEST(10, "ADDITIONAL_REQUEST"),
        APPROVED(11, "APPROVED_PROFILE"),
        REJECT(12, "REJECT_PROFILE");

        private final int id;
        private final String name;
    }

    @Getter
    @AllArgsConstructor
    public enum RESULT_STATUS {
        SUCCESS(200),
        NOT_FOUND(404),
        FORBIDDEN(403),
        FAILED(400);
        private final int id;
    }
}
