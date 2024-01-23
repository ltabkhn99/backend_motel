package vn.oceantech.l3pre.constants;

public class StoredProcedure {
    public static final String GET_USER_BY_ID = "get_user_by_user_id";
    public static final String GET_USER_BY_USERNAME = "get_user_by_username";
    public static final String EXISTS_LEADER_BY_ID = "exists_leader_by_id";

    public static class Role{
        public static final String GET_BY_ID = "get_role_by_id";
    }
    public static class EmployeeInformation{
        public static final String CREATE = "create_employee_information";
        public static final String UPDATE = "update_employee_information";
        public static final String SUBMIT_TO_LEADER = "submit_employee_information_to_leader";
        public static final String LEADER_APPROVE = "leader_approve_employee_information";
        public static final String GET_BY_ID = "get_employee_information_by_id";
        public static final String GET_ALL = "get_all_employee_information";
        public static final String GET_BY_STATUS_ID = "get_employee_information_by_status_id";
        public static final String EXISTS_BY_ID = "exists_employee_information_by_id";
        public static final String CHECK_DUPLICATE_CREATE = "check_duplicate_create_employee_information";
        public static final String CHECK_DUPLICATE_UPDATE = "check_duplicate_update_employee_information";
    }

    public static class EmployeeProfile{
        public static final String DELETE_BY_ID = "delete_employee_profile_by_id";
    }

    public static class Certificate{
        public static final String CREATE = "create_certificate";
        public static final String UPDATE = "update_certificate";
        public static final String GET_BY_ID = "get_certificate_by_id";
        public static final String GET_BY_EMPLOYEE_ID = "get_certificate_by_employee_id";
        public static final String DELETE_BY_ID = "delete_certificate_by_id";
        public static final String EXISTS_BY_ID = "exists_certificate_by_id";
    }

    public static class FamilyRelationship{
        public static final String CREATE = "create_family_relationship";
        public static final String UPDATE = "update_family_relationship";
        public static final String DELETE_BY_ID = "delete_family_relationship_by_id";
        public static final String GET_BY_ID = "get_family_relationship_by_id";
        public static final String GET_BY_EMPLOYEE_ID = "get_family_relationship_by_employee_id";
        public static final String EXISTS_BY_ID = "exists_family_relationship_by_id";
    }

    public static class EndedInformation{
        public static final String CREATE = "create_ended_information";
        public static final String UPDATE_BY_MANAGER = "update_ended_information_by_manager";
        public static final String UPDATE_BY_LEADER = "update_ended_information_by_leader";
        public static final String SUBMIT = "submit_ended_information";
        public static final String LEADER_APPROVE = "leader_approve_ended_information";
        public static final String DELETE_BY_ID = "delete_ended_information_by_id";
        public static final String GET_BY_ID = "get_ended_information_by_id";
        public static final String GET_ALL = "get_all_ended_information";
        public static final String GET_PENDING = "get_ended_information_pending";
        public static final String EXISTS_BY_ID = "exists_ended_information_by_id";
    }

    public static class RecordEndedProfile{
        public static final String CREATE = "create_record_ended_profile";
        public static final String UPDATE_BY_MANAGER = "update_record_ended_profile_by_manager";
        public static final String UPDATE_BY_LEADER = "update_record_ended_profile_by_leader";
        public static final String LEADER_APPROVE = "leader_approve_record_ended_profile";
        public static final String DELETE_BY_ID = "delete_record_ended_profile_by_id";
        public static final String GET_BY_ID = "get_record_ended_profile_by_id";
        public static final String GET_PENDING = "get_record_ended_profile_pending";
        public static final String SUBMIT_TO_LEADER = "submit_record_ended_profile_to_leader";
        public static final String EXISTS_BY_ID = "exists_record_ended_profile_by_id";

    }

    public static class RegistrationInformation {
        public static final String CREATE_NEW
                = "insert_registration_information_by_manager";
        public static final String GET_ALL_BY_LEADER
                = "get_page_registration_information_by_status_and_leader";
        public static final String GET_ALL_BY_MANAGER
                = "get_page_registration_information_by_manager";
        public static final String GET_DETAIL
                = "get_detail_registration_information_by_id";
        public static final String UPDATE_BY_MANAGER
                = "update_registration_information_by_manager";
        public static final String UPDATE_BY_LEADER
                = "update_registration_information_by_leader";
        public static final String SUBMIT_TO_LEADER_BY_MANAGER
                = "submit_registration_information_to_leader_by_manager";
        public static final String DELETE_BY_ID
                = "delete_registration_information_by_id";
    }

    public static class PromotionProfile {
        public static final String CREATE_NEW = "insert_promotion_profile_by_manager";
        public static final String GET_BY_ID = "get_detail_promotion_profile_by_id";
        public static final String GET_ALL_BY_LEADER = "get_page_promotion_profile_by_status_and_leader";
        public static final String GET_ALL_BY_MANAGER = "get_page_promotion_profile_by_manager";
        public static final String SUBMIT_TO_LEADER_BY_MANAGER = "submit_promotion_profile_to_leader_by_manager";
        public static final String UPDATE_BY_LEADER = "update_promotion_profile_by_leader";
        public static final String UPDATE_BY_MANAGER = "update_promotion_profile_by_manager";
        public static final String DELETE_BY_ID = "delete_promotion_profile_by_register_id";
    }

    public static class ProposalProfile {
        public static final String CREATE_NEW = "insert_proposal_profile_by_manager";
        public static final String GET_BY_REGISTER_PROFILE_ID = "get_detail_proposal_profile_by_register_profile_id";
        public static final String GET_ALL_BY_LEADER = "get_page_proposal_profile_by_status_and_leader";
        public static final String GET_ALL_BY_MANAGER = "get_page_proposal_profile_by_manager";
        public static final String SUBMIT_TO_LEADER_BY_MANAGER = "submit_proposal_profile_to_leader_by_manager";
        public static final String UPDATE_BY_LEADER = "update_proposal_profile_by_leader";
        public static final String UPDATE_BY_MANAGER = "update_proposal_profile_by_manager";
        public static final String DELETE_BY_ID = "delete_proposal_profile_by_register_id";
    }

    public static class SalaryIncrementProfile {
        public static final String CREATE_NEW = "insert_salary_increment_profile_by_manager";
        public static final String GET_BY_REGISTER_PROFILE_ID = "get_detail_salary_increment_profile_by_register_profile_id";
        public static final String GET_ALL_BY_LEADER = "get_page_salary_increment_profile_by_status_and_leader";
        public static final String GET_ALL_BY_MANAGER = "get_page_salary_increment_profile_by_manager";
        public static final String SUBMIT_TO_LEADER_BY_MANAGER = "submit_salary_increment_profile_to_leader_by_manager";
        public static final String UPDATE_BY_LEADER = "update_salary_increment_profile_by_leader";
        public static final String UPDATE_BY_MANAGER = "update_salary_increment_profile_by_manager";
        public static final String DELETE_BY_ID = "delete_salary_increment_profile_by_register_id";
    }


}
