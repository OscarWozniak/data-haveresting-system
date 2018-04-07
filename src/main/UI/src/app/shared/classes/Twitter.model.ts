export class TwitterModel {
  public friendIdName: string;
  public auth = new TwitterAuth();
  public limit: number;
}


export class TwitterAuth {
  public accessToken: string;
  public accessTokenSecret: string;
  public consumerKey: string;
  public consumerSecret: string;
}
