class ProfilePage {
  header;
  logoutButton;

  constructor() {
    this.header = element(by.tagName("h1"));
    this.logoutButton = element(by.tagName("button"));
  }
}

const profilePage = new ProfilePage();
module.exports = profilePage;
