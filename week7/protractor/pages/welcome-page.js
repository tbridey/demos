class WelcomePage {
  username;
  password;
  submitButton;

  constructor() {
    this.username = element(by.id("username"));
    this.password = element(by.id("password"));
    this.submitButton = element(by.tagName("button"));
  }
}

const welcomePage = new WelcomePage();
module.exports = welcomePage;
