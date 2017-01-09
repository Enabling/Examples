EnCo PHP example
================

Welcome to the PHP based authentication example.
This example will perform the following steps:

1. Security initialisation
1. Retrieval of the userinfo
1. Interprete the JSON answer in a structured way

To run the example, you will need to :

1. have a working PHP setup, be it server or cli
1. install the php5-curl module, which is required for httpful library used in the example
1. install the [**Httpful library**](http://phphttpclient.com/)
1. update the example with your own client_id and client_secret
1. run the example

The following sections provide more detail on how to install the prerequisites and run the example.


## Installing httpful library

    # Install prerequisites
    sudo apt-get update
    sudo apt-get install php5-curl

    # Either download httpful.phar from main website, or use version provided in example
    # To automatically download from main website:
    curl -o 'httpful.phar' http://phphttpclient.com/downloads/httpful.phar

## Running example

The following section details how to run the example.

    # Create example file and update example with your own client_id and client_secret
    vi auth_example.php

    # Run example
    php -f auth_example.php

# Feedback

You're welcome to have a go with these and we welcome your comments, feedback, improvements, questions, ....

And if needed, you will find related information on our [**documentation site**](http://docs.enco.io/) as well.

Cheers,
The EnCo team.
