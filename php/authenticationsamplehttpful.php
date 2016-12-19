<?php
// Point to where you downloaded the phar
include('./httpful.phar');
use Httpful\Request;

// Replace with you own client ID and secret
$client_id = "<< YOUR INFO HERE >>";
$client_secret = "<< YOUR INFO HERE >>";

// Make a request to the EnCo API to acquire a token
$url = "https://api.enco.io/token";
$payload = "grant_type=client_credentials&scope=openid";

// Execute the token request
$response = Request::post($url)
    ->body($payload)
    ->authenticateWith($client_id, $client_secret)
    ->expectsJson()
    ->send();

echo "Token response:\n{$response}\n\n";

echo "Access token received {$response->body->access_token}.\n\n";

$auth_header = "Bearer {$response->body->access_token}";

$response = Request::get('https://api.enco.io/userinfo?schema=openid')
    ->addHeader('Authorization', $auth_header)
    ->expectsJson()
    ->send();

echo "User info response:\n{$response}\n\n";
echo "Hello {$response->body->name}.\n";
echo "\t{$response->body->given_name}, {$response->body->family_name}\n";
echo "\te-mail: {$response->body->email}.\n";
?>