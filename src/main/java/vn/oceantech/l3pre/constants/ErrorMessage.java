package vn.oceantech.l3pre.constants;

public class ErrorMessage {
    public static final String EXPIRED_DATE = "This date must be in one month from now!";
    public static final String FIELD_NOT_BLANK = "This field must be not empty";
    public static final String FIELD_NOT_NULL = "This field must not be null";
    public static final String DENIED_ACCESS = "You haven't permission to access to this entity";
    public static final String INVALID_ID = "ID value is not valid, must be bigger than 1!";
    public static final String CANNOT_UPDATED_BY_LEADER = "Status of profile is not valid!";
    public static final String INVALID_NUMBER_OF_TIMES = "The number of times value, must be bigger than 1!";
    public static final String EMAIL_TYPE_INCORRECT = " This email must be correct";
    public static final String PHONE_NUMBER_TYPE = " The phone number must have at least 10 to 11 numbers";
    public static final String IDENTIFICATION_NUMBER_TYPE = " The identification number have 9 or 12 numbers";
    public static final String CONVERT_OBJECT_TO_JSON_ERROR = "Convert object to json error";
    public static final String AGE_NOT_UNDER_18 = " Age must be 18 years or older";
    public static final String AGE_NOT_MORE_THAN_60 = " Age must not be more than 60 years old";
    public static final String DATE_NOT_FUTURE = " Date cannot be in the future";
    public static final String NOT_FOUND_LEADER = " Not found leader";

    public static class SECURITY {
        public static final String NOT_LOGGED = "You haven't logged, please login with your account to continue!";
        public static final String UNAUTHORIZED = "Your account or password is incorrect";
        public static final String MANAGER_ROLE = "You dont have permission to access this resource" +
                ", please login with Manager account to continue!";
        public static final String LEADER_ROLE = "You dont have permission to access this resource" +
                ", please login with Leader account to continue!";
    }

    public static class REGIS_INFORMATION {
        public static final String INVALID_APPOINTMENT_DATE = "Appointment date must be valid in one month from now!";
        public static final String NOT_YET_SUBMITTED
                = "This registration information had not submitted by manager, so you can't access this!";
    }

    public static class PromotionProfile {
        public static final String PROMOTION_DATE = "The promotion date must be today or some day in one month from now!";
    }

    public static class ProposalProfile {
        public static final String PROPOSAL_DATE = "The proposal date must be today or some day in one month from now!";
    }

    public static class SalaryIncrementProfile {
        public static final String INVALID_SALARY_RANK = "The salary rank must be bigger than 0!";
        public static final String SALARY_INCREMENT_DATE = "The salary increment date must be today or some day in one month from now!";
    }

    public static class EmployeeInformation {
        public static final String NOT_FOUND = " Not found employee information";
        public static final String NOT_ALLOW_UPDATE = " Employee information update when status are new, additional request and reject ";
        public static final String MANAGER_NOT_ALLOW_UPDATE_DELETE_AND_SUBMIT_EMPLOYEE_PROFILE = " The manager creates an employee profile " +
                "with the right to edit, delete and submit the employee profile";
    }

    public static class Certificate {
        public static final String NOT_FOUND = " Not found certificate";
        public static final String NOT_ALLOW_ADD_UPDATE_AND_DELETE = " Add, update and delete certificate when status employee are new, additional request and reject ";
        public static final String MANAGER_NOT_ALLOW_ADD = " The manager creates an employee profile " +
                "with the right to add certificate for employee";
    }

    public static class FamilyRelationship {
        public static final String NOT_FOUND = " Not found family relationship";
        public static final String NOT_ALLOW_ADD_UPDATE_AND_DELETE = " Add, update and delete family relationship when status employee are new, additional request and reject ";
        public static final String MANAGER_NOT_ALLOW_ADD = " The manager creates an employee profile " +
                "with the right to add family relationship for employee";
    }

    public static class EndedInformation {
        public static final String NOT_FOUND = " Not found ended information";
        public static final String NOT_EXCEED_3_MONTHS = " Ended date cannot exceed 3 months";
        public static final String MANAGER_NOT_ALLOW_END_EMPLOYEE_PROFILE = " The manager creates an employee profile " +
                "with the right to end the employee profile";
        public static final String MANAGER_NOT_ALLOW = " The manager creates an ended information " +
                "with the right to update,submit and delete ended information";
        public static final String NOT_ALLOW_CREATE = " Only employee profiles with an approved status are allowed end profile";
        public static final String NOT_ALLOW_UPDATE = " Ended information update when status are new, additional request and reject ";
        public static final String NOT_ALLOW_SUBMIT = " Ended information submit to leader when status are new, additional request";
        public static final String NOT_ALLOW_ADDITION_REQUEST_AND_APPROVE = " Leader request additional, approve or reject ended information when status are pending";
        public static final String LEADER_NOT_ALLOW_ADDITION_REQUEST_AND_APPROVE = " Leader not allow additional request and approve ended information";
    }

    public static class RecordEndedProfile {
        public static final String NOT_FOUND = " Not found record ended profile";
        public static final String NOT_EXCEED_3_MONTHS = " Decision date cannot exceed 3 months";
        public static final String MANAGER_NOT_ALLOW_RECORD = " The manager creates an employee profile " +
                "with the right to record the employee profile";
        public static final String MANAGER_NOT_ALLOW = " The manager creates an record ended profile " +
                "with the right to update,submit and delete record ended profile";
        public static final String LEADER_NOT_ALLOW_ADDITION_REQUEST_AND_APPROVE = " Leader not allow additional request and approve record ended profile";
        public static final String NOT_ALLOW_CREATE = " Only employee profiles with an ended status are allowed record profile";
        public static final String NOT_ALLOW_UPDATE = " Record ended information update when status are new, additional request and reject ";
        public static final String NOT_ALLOW_SUBMIT = " Record ended profile submit to leader when status are new, additional request";
        public static final String NOT_ALLOW_ADDITION_REQUEST = " Leader request additional record ended profile when status are pending";
        public static final String NOT_ALLOW_ADDITION_REQUEST_AND_APPROVE = " Leader request additional, approve or reject record ended profile when status are pending";
    }
}

