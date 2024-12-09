package com.ivanpak.bookproj;

import com.ivanpak.bookproj.book.dto.BookDTO;
import com.ivanpak.bookproj.book.model.Book;
import com.ivanpak.bookproj.book.repository.BookRepository;
import com.ivanpak.bookproj.book.service.BookServiceI;
import com.ivanpak.bookproj.book.service.BookServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
class BookServiceMockTests {

	@Mock
	private BookRepository bookRepository;

	@InjectMocks
	private BookServiceImpl bookService;



	@Test
	void testSave() {
		Book bookSaved = Book.builder()
				.title("titolo del book saved")
				.author("autore1")
				.build();
		Mockito.when(bookRepository.save(Mockito.any()))
				.thenReturn(bookSaved);
		BookDTO bookDTOSaved = bookService.save(BookDTO.builder().build());
		System.out.println(bookDTOSaved.getAuthor());
	}

}
