# PocketLawyer
## Concept
Uses voice recognition to assist users during interaction with law enforcement.
   1. Automatically reminds users of their rights in certain situations
   2. Encourages lawful and respectful behavior from all parties
   3. Provides a record of interactions

Generates a database of law enforcement interactions for research:
   1. Stores annotated transcripts in DynamoDB on Amazon Web Services
   2. Associates records with time, location, and optional demographic information
   3. Can easily be analyzed by regulatory agencies and advocacy groups

## Usage
Once PocketLawyer is activated, it listens to all nearby speech. It automatically recognizes common situations and provides advice. By listening directly to the conversation, it may recognize things that the user would not. Automatic functionality allows the user to focus on what they are doing, and not the app.

Examples:
   1. If it seems that a user is being asked to volunteer to be searched, it reminds them that they do not have to consent to a search.
   2. If the user is given a traffic ticket, it will suggest that the user not argue with the officer, and remind them that they can argue it in court. Data recorded by PocketLawyer could be used by the user’s real lawyers.

## Technologies Used
Speech recognition is performed by IBM Watson, which generates transcripts, identifies keywords, and also produces an analysis of speaker identity. IBM Watson is also used for text-to-speech to provide advice. Using this framework will allow PocketLawyer to take advantage of ongoing advances in this rapidly developing field.

Annotated transcripts are stored in a DynamoDB instance hosted on Amazon Web Services.

## Challenges we ran into
We had trouble with threading while connecting the synchronous and asynchronous portions of our app.

## What we learned
Watson and DynamoDB are both awesome.

## What's next for PocketLawyer
   1. Expand scenarios with appropriate legal advice: We are not lawyers, all advice provided by this implementation is for example only.
   2. Perform analysis on stored data using AWS Lambda and Amazon Machine Learning.
   3. Set up a secure web interface for user and researcher accounts.
