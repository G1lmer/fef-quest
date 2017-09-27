package com.kharazin.fef.movenko.quest.constant;


public final class EntityFields {

    private EntityFields() {
    }

    public static final String ID= "id";

    public static final class User {

        private User(){

        }

        public static final String USERS_ID = "users.id";

        public static final String PASSWORD = "password";

        public static final String EMAIL = "email";

        public static final String NAME = "users.name";

        public static final String SURNAME = "surname";

        public static final String FATHER_NAME = "father_name";

        public static final String IS_CAPTAIN = "is_captain";
    }

    public static final class Group {

        private Group() {

        }

        public static final String GROUPS_ID = "groups.id";

        public static final String NAME = "groups.team_name";

        public static final String TEAM_LOGIN = "team_login";

        public static final String SCHOOL_NAME = "school_name";

        public static final String MEMBERS = "members";
    }
}
