import http_client
import ubinascii

client_id = '<< YOUR INFO HERE >>'
client_secret = '<< YOUR INFO HERE >>'

basic_auth = ubinascii.b2a_base64("{}:{}".format(client_id, client_secret)).decode('ascii')
auth_header = {'Authorization':'Basic {}'.format(basic_auth), 'Accept':'application/json'}
payload = 'grant_type=client_credentials&scope=openid'

print("Acquiring token")
print()
r = http_client.post("https://api.enco.io/token", headers=auth_header, textMsg=payload, contentType='application/x-www-form-urlencoded')
print(r.text)
authInfo = r.json()
tokenBearer = authInfo['access_token']

print()
print("Using token to retrieve user information")
print()
auth_header = {'Authorization':'Bearer {}\r\n'.format(tokenBearer), 'Accept':'application/json'}
r = http_client.get("https://api.enco.io/userinfo?schema=openid", headers=auth_header)
print(r.text)
userInfo = r.json()

print()
print("Hello %s" % userInfo['name'])
print("\t%s, %s" % (userInfo['given_name'], userInfo['family_name']))
print("\teMail: %s" % userInfo['email'])
