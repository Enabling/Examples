<?php

////////////////////////////////////////////////////////////////////////////////
// !!! REPLACE WITH YOU OWN CLIENT ID AND SECRET !!!

$client_id = "<< YOUR INFO HERE >>";
$client_secret = "<< YOUR INFO HERE >>";

////////////////////////////////////////////////////////////////////////////////

// Include httpful phar library for token request
include('./httpful.phar');
use Httpful\Request;

///////////////////////////////////
// STEP 1: Security initialisation
////////////////////////////////////////////////////////////////////////////////

// Make a request to the EnCo API token endpoint to acquire a token
$url = "https://api.enco.io/token";
$payload = "grant_type=client_credentials&scope=openid";
$response = Request::post($url)
    ->body($payload)
    ->authenticateWith($client_id, $client_secret)
    ->expectsJson()
    ->send();

echo "Token response:\n{$response}\n\n";
echo "Access token received: {$response->body->access_token}\n\n";

/////////////////////////////////////
// STEP 2: Retrieval of the userinfo
////////////////////////////////////////////////////////////////////////////////

// Access token validation
$auth_header = "Bearer {$response->body->access_token}";
$response = Request::get('https://api.enco.io/userinfo?schema=openid')
    ->addHeader('Authorization', $auth_header)
    ->expectsJson()
    ->send();
echo "User info response:\n{$response}\n\n";

//////////////////////////////////////////////////////////
// STEP 3: Interprete the JSON answer in a structured way
////////////////////////////////////////////////////////////////////////////////

if (property_exists($response->body, 'error')){
    echo '[ERROR] ' . $response->body->error . ": " . $response->body->error_description + '\n';
} else {
    echo "Hello {$response->body->name}.\n";
    echo "\tGiven name: {$response->body->given_name}, Family name: {$response->body->family_name}\n";
    echo "\te-mail: {$response->body->email}.\n";
}

?>