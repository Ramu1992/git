package main;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class interview2{

	public WebDriver driver;

	public void small() {
		int[] Ar = { 2, 3, 4, 99, 58, 93, 176 };
System.out.println("wel come" );
		int small = Ar[0];
		int big = Ar[0];
		for (int i = 0; i < Ar.length; i++) {
			if (Ar[i] > big) {
				big = Ar[i];
			} else if (Ar[i] < small) {
				small = Ar[i];
			}
		}

		System.out.println("big number=" + big + " small number=" + small);
	}

	public void sort() {

		int[] pra = { 55, 6, 99, 52, 36, 64, 5, 89, 7 };
		for (int nn : pra) {
			System.out.print(nn + ",");
		}
		System.out.println("After sorting");
		Arrays.sort(pra);
		for (int nn : pra) {
			System.out.print(nn + ",");
		}
	}

	public void sorting() {
		int n, temp;
		Scanner s = new Scanner(System.in);
		System.out.print("Enter no. of elements you want in array:");
		n = s.nextInt();
		int a[] = new int[n];
		System.out.println("Enter all the elements:");
		for (int i = 0; i < n; i++) {
			a[i] = s.nextInt();
		}
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[i] > a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		System.out.print("Ascending Order:");
		for (int i = 0; i < n - 1; i++) {
			System.out.print(a[i] + ",");
		}
		System.out.println(a[n - 1]);
	}

	// taking screen shot

	public void openBrowser() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		try {
			// the below statement will throw an exception as the element is not
			// found, Catch block will get executed and takes the screenshot.
			driver.findElement(By.id("testing")).sendKeys("test");

			// if we remove the below comment, it will not return exception and
			// screen shot method will not get executed.
			// driver.findElement(By.id("gbqfq")).sendKeys("test");
		} catch (Exception e) {
			System.out.println("I'm in exception");
			// calls the method to take the screenshot.
			getscreenshot();
		}
	}

	public void getscreenshot() throws Exception {
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File("D:\\scr.png"));
	}

	// taking screen shot

	// slider moving

	public void slider() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://jqueryui.com/slider/");
		String tit = driver.getTitle();
		System.out.println(tit);
		Assert.assertEquals(tit, "Slider | jQuery UI");
		driver.switchTo().frame(0);
		WebElement slider = driver.findElement(By.cssSelector("#slider > span"));
		Actions s = new Actions(driver);
		s.clickAndHold(slider);
		s.moveByOffset(40, 0);
		s.release();
		s.build().perform();

	}
	// palindrome

	public void palindrome() {
		int r, sum = 0, temp;
		int n = 101;// It is the number variable to be checked for palindrom
		temp = n;
		while (n > 0) {

			r = n % 10; // getting remainder
			n = n / 10;
			sum = (sum * 10) + r;
			System.out.println(sum);

		}
		System.out.println(sum);
		if (temp == sum)
			System.out.println("palindrome number ");
		else

			System.out.println("not palindrome");
	}

	// prime number
	public void primenumber() {

		int i, m = 0, flag = 0;
		System.out.println("enter the number");
		Scanner ii = new Scanner(System.in);
		int n = ii.nextInt();// it is the number to be checked
		m = n / 2;
		for (i = 2; i <= m; i++) {
			if (n % i == 0) {
				System.out.println("Number is not prime");
				flag = 1;
				break;
			}
		}
		if (flag == 0) {
			System.out.println("Number is prime");
		}
		int num = 20, count;
		for (int p = 1; p <= num; p++) {
			count = 0;
			for (int j = 2; j <= p / 2; j++) {
				if (p % j == 0) {
					count=1;
					break;
				}
			}

			if (count == 0) {
				System.out.println(p);
			}
		}
	}

	// factorial num
	public void factorial() {
		int i, fact = 1;
		int number = 5;// It is the number to calculate factorial.
		for (i = 1; i <= number; i++) {
			fact = fact * i;
		}
		System.out.println("Factorial of " + number + " is: " + fact);

	}

	public void fabinaki() {

		int imn = 10, f;
		/*
		 * System.out.print("Enter the number to know the fobinaci series");
		 * Scanner i = new Scanner(System.in); imn = i.nextInt();
		 */
		int f1, f2 = 0, f3 = 1;
		for (int ii = 0; ii <= imn; ii++) {
			f1 = f2;
			f2 = f3;
			f3 = f1 + f2;
			System.out.print(f3 + ",");

		}
	}

	public void stringrev() {

		String original, reverse = "";
		/*
		 * Scanner in = new Scanner(System.in);
		 * 
		 * System.out.println("Enter a string to reverse"); original =
		 * in.nextLine();
		 */

		original = "Enter a string to reverse";
		int length = original.length();
		for (int i = length - 1; i >= 0; i--)
			reverse = reverse + original.charAt(i);

		System.out.println("Reverse of entered string is: " + reverse);
	}

	public void digisum() {
		int n = 123, r, sum = 0;
		while (n > 0) {
			r = n % 10;
			sum = sum + r;
			n = n / 10;
		}
		System.out.println(sum);
	}

	static void unique_array(int[] a) {

		// Assuming all elements in input array are unique

		int nue = a.length;

		// Comparing each element with all other elements

		for (int i = 0; i < nue; i++) {
			for (int j = i + 1; j < nue; j++) {
				// If any two elements are found equal

				if (a[i] == a[j]) {
					// Replace duplicate element with last unique element

					a[j] = a[nue - 1];

					nue--;

					j--;
				}
			}
		}

		// Copying only unique elements of a into array1

		int[] array1 = Arrays.copyOf(a, nue);

		// Printing arrayWithoutDuplicates

		for (int i = 0; i < array1.length; i++) {
			System.out.print(array1[i] + "\t");
		}
	}




	public static void main(String[] args) {
		interview2 b = new interview2();
		// .stringrev();
		// .digisum();
	//	b.unique_array(new int[] {1,2,2,4});
		//b.prim();

	}

}
