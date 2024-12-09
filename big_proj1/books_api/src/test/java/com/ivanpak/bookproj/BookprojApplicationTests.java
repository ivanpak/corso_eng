package com.ivanpak.bookproj;

import com.ivanpak.bookproj.book.dto.BookDTO;
import com.ivanpak.bookproj.book.repository.BookRepository;
import com.ivanpak.bookproj.book.service.BookServiceI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookprojApplicationTests {

	@Autowired
	private BookServiceI bookService;

	@Autowired
	private BookRepository bookRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testSave() {
		bookRepository.deleteAll();
		BookDTO bookToSave = BookDTO.builder()
				.title("Titolo del libro di test")
				.author("Autore del libro di test")
				.build();

		BookDTO bookSaved = bookService.save(bookToSave);

		Assertions.assertNotNull(bookSaved.getUuid());
	}

}
