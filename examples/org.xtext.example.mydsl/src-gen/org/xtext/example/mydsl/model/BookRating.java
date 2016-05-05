/**
 */
package org.xtext.example.mydsl.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Book Rating</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A rating of a book.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.model.BookRating#getBook <em>Book</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.model.BookRating#getRating <em>Rating</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.model.ModelPackage#getBookRating()
 * @model annotation="http://www.eclipse.org/emf/2002/GenModel version='2' doorsId='17'"
 * @generated
 */
public interface BookRating extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Book</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The referred book.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Book</em>' reference.
	 * @see #setBook(Book)
	 * @see org.xtext.example.mydsl.model.ModelPackage#getBookRating_Book()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel version='2' doorsId='18'"
	 * @generated
	 */
	Book getBook();

	/**
	 * Sets the value of the '{@link org.xtext.example.mydsl.model.BookRating#getBook <em>Book</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Book</em>' reference.
	 * @see #getBook()
	 * @generated
	 */
	void setBook(Book value);

	/**
	 * Returns the value of the '<em><b>Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The rating of the book out of 10.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Rating</em>' attribute.
	 * @see #setRating(int)
	 * @see org.xtext.example.mydsl.model.ModelPackage#getBookRating_Rating()
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel version='2' doorsId='19'"
	 * @generated
	 */
	int getRating();

	/**
	 * Sets the value of the '{@link org.xtext.example.mydsl.model.BookRating#getRating <em>Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rating</em>' attribute.
	 * @see #getRating()
	 * @generated
	 */
	void setRating(int value);

} // BookRating
