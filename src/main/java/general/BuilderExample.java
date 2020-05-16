package main.java.general;

public class BuilderExample {

    private String firstName;
    private String lastName;
    private String emailAddress;

    public static class Builder {

        private String firstName;
        private String lastName;
        private String emailAddress;

        public Builder ( String emailAddress ) {
            this.emailAddress = emailAddress;
        }

        public Builder withFirstName( String firstName ) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName( String lastName ) {
            this.lastName = lastName;
            return this;
        }

        public BuilderExample build() {
            return new BuilderExample( this );
        }
    }

    private BuilderExample( Builder builder ) {
        firstName = builder.firstName;
        lastName = builder.lastName;
        emailAddress = builder.emailAddress;
    }
}
