import requests

client_id = '<< YOUR INFO HERE >>'
client_secret = '<< YOUR INFO HERE >>'

payload = {'grant_type': 'client_credentials', 'scope': 'openid'}

print "Acquiring token"
print
r = requests.post("https://api.enco.io/token", data=payload, auth=(client_id, client_secret))
print(r.text)
authInfo = r.json()
tokenBearer = authInfo['access_token']

print
print "Using token to retrieve user information"
print
auth_header = {'Authorization':'Bearer {}'.format(tokenBearer), 'Accept':'application/json'}
r = requests.get("https://api.enco.io/userinfo?schema=openid", headers=auth_header)
print(r.text)
userInfo = r.json()

print
print "Hello %s" % userInfo['name']
print "\t%s, %s" % (userInfo['given_name'], userInfo['family_name'])
print "\teMail: %s" % userInfo['email']
