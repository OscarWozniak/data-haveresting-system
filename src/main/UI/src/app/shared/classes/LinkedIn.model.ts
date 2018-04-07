export class LinkedInModel {
  public limit: number;
  public auth = new LinkedInAuth();
}

export class LinkedInAuth {
  public login: string;
  public password: string;
}
