package vn.oceantech.l3pre.constants;

public class ColumnName {
    public static class Certificate {
        public static final String ID = "id";
        public static final String EMPLOYEE_ID = "employee_id";
        public static final String RANK_C = "rank_c";
        public static final String TYPE = "type";
        public static final String FIELD = "field";
        public static final String ISSUER = "issuer";
        public static final String ISSUE_DATE = "issue_date";
        public static final String ISSUE_PLACE = "issue_place";
        public static final String CONTENT = "content";
    }

    public static class FamilyRelationship {
        public static final String ID = "id";
        public static final String EMPLOYEE_ID = "employee_id";
        public static final String NAME = "name";
        public static final String GENDER = "gender";
        public static final String BIRTHDATE = "birthdate";
        public static final String JOB = "job";
        public static final String WORK_PLACE = "work_place";
        public static final String IDENTIFICATION_NUMBER = "identification_number";
        public static final String PHONE_NUMBER = "phone_number";
        public static final String EMAIL = "email";
        public static final String ADDRESS = "address";
        public static final String RELATIONSHIP = "relationship";
    }

    public static class EmployeeInformation {
        public static final String ID = "id";
        public static final String CODE = "code";
        public static final String NAME = "name";
        public static final String GENDER = "gender";
        public static final String BIRTHDATE = "birthdate";
        public static final String PERMANENT_ADDRESS = "permanent_address";
        public static final String ORIGIN_PLACE = "origin_place";
        public static final String ETHNIC = "ethnic";
        public static final String RELIGION = "religion";
        public static final String PHONE_NUMBER = "phone_number";
        public static final String EMAIL = "email";
        public static final String IMAGE_PATH = "image_path";
        public static final String IDENTIFICATION_NUMBER = "identification_number";
        public static final String ISSUE_DATE = "issue_date";
        public static final String ISSUE_PLACE = "issue_place";
        public static final String SALARY = "salary";
        public static final String SALARY_RANK = "salary_rank";
        public static final String DEPARTMENT_ID = "department_id";
        public static final String POSITION_ID = "position_id";
        public static final String STATUS_ID = "status_id";
        public static final String STATUS_NAME = "status_name";
        public static final String CREATED_BY = "created_by";
    }

    public static class EndedInformation {
        public static final String ID = "id";
        public static final String ENDED_DATE = "ended_date";
        public static final String ENDED_REASON = "ended_reason";
        public static final String ENDED_NUMBER = "ended_number";
        public static final String SUBMISSION_DATE = "submission_date";
        public static final String ADDITIONAL_REQUEST = "additional_request";
        public static final String EMPLOYEE_ID = "employee_id";
        public static final String LEADER_ID = "leader_id";
        public static final String STATUS_ID = "status_id";
        public static final String STATUS_NAME = "status_name";
        public static final String CREATED_BY = "created_by";
    }

    public static class RecordEndedProfile {
        public static final String ID = "id";
        public static final String DECISION_DATE = "decision_date";
        public static final String SAVE_NUMBER = "saved_number";
        public static final String SUBMISSION_DATE = "submission_date";
        public static final String LEADER_ID = "leader_id";
        public static final String EMPLOYEE_ID = "employee_id";
        public static final String ADDITIONAL_REQUEST = "additional_request";
        public static final String STATUS_ID = "status_id";
        public static final String STATUS_NAME = "status_name";
        public static final String CREATED_BY = "created_by";
    }

    public static class RegistrationInformation {
        public static final String ID = "id";
        public static final String CONTENT = "content";
        public static final String CV_PATH = "cvPath";
        public static final String SUBMISSION_DATE = "submissionDate";
        public static final String REJECT_DATE = "rejectDate";
        public static final String REJECT_REASON = "rejectReason";
        public static final String APPROVED_DATE = "approvedDate";
        public static final String APPOINTMENT_DATE = "appointmentDate";
        public static final String EMPLOYEE_ID = "employeeId";
        public static final String MANAGER_ID = "managerId";
        public static final String LEADER_ID = "leaderId";
        public static final String STATUS_MESSAGE = "statusMessage";
        public static final String STATUS_ID = "statusId";
    }

    public static class RegisterProfile {
        public static final String ID = "id";
        public static final String CONTENT = "content";
        public static final String NOTE = "note";
        public static final String EMPLOYEE_ID = "employeeId";
        public static final String LEADER_ID = "leaderId";
        public static final String CREATED_BY = "createdBy";
        public static final String SUBMISSION_DATE = "submissionDate";
        public static final String REJECT_DATE = "rejectDate";
        public static final String REJECT_REASON = "rejectReason";
        public static final String APPROVED_DATE = "approvedDate";
        public static final String STATUS_ID = "statusId";
        public static final String STATUS_MESSAGE = "statusMessage";
    }

    public static class PromotionProfile {
        public static final String DATE = "promotionDate";
        public static final String NUMBER_OF_TIMES = "numberOfTimes";
        public static final String REASON = "reason";
        public static final String CURRENT_POSITION = "currentPosition";
        public static final String PROMOTION_POSITION = "promotionPosition";
    }

    public static class ProposalProfile {
        public static final String PROPOSAL_DATE = "proposalDate";
        public static final String CONTENT = "contentOfProposal";
        public static final String TYPE = "typeOfProposal";
    }

    public static class SalaryIncrementProfile {
        public static final String INCREMENT_DATE = "salaryIncrementDate";
        public static final String NUMBER_OF_TIMES = "numberOfTimes";
        public static final String REASON = "reason";
        public static final String RANK = "salaryRank";
        public static final String SALARY = "salary";
    }
    public static class Role {
        public static final String ID = "id";
        public static final String NAME = "name";
    }

    public static class User {
        public static final String ID = "id";
        public static final String USERNAME = "username";
        public static final String PASSWORD = "password";
        public static final String NAME = "name";
        public static final String PHONE_NUMBER = "phone_number";
        public static final String EMAIL = "email";
        public static final String IMAGE_PATH = "image_path";
        public static final String ROLE_ID = "role_id";
        public static final String POSITION_ID = "position_id";
    }


}
