#include <boost/beast/http.hpp>
#include <boost/asio.hpp>

namespace http = boost::beast::http; // Alias pentru biblioteca HTTP

int main() {
    // Creează un context pentru I/O
    boost::asio::io_context ioc;

    // Creează un endpoint IP și port
    boost::asio::ip::tcp::endpoint endpoint{boost::asio::ip::tcp::v4(), 8080};

    // Creează un acceptor pentru a asculta conexiuni la endpoint
    boost::asio::ip::tcp::acceptor acceptor{ioc, endpoint};

    while (true) {
        // Așteaptă și acceptă o conexiune de la un client
        boost::asio::ip::tcp::socket socket{ioc};
        acceptor.accept(socket);

        // Creează un obiect de cerere HTTP
        http::request<http::string_body> request;
        http::read(socket, request);

        // Răspunde cu o pagină HTML simplă
        http::response<http::string_body> response;
        response.version(request.version());
        response.result(http::status::ok);
        response.set(http::field::server, "My C++ Web Server");
        response.body() = "<html><body><h1>Bun venit pe site-ul meu!</h1></body></html>";
        response.prepare_payload();

        // Trimite răspunsul la client
        http::write(socket, response);
    }

    return 0;
}