package pl.waw.sgh;
import java.util.Scanner;

public class EmailVerifier {
    public static void main(String[] args) {
        String email;
        System.out.println("Insert your email address." +
                "\nIt should contain letters, digits, only one use of @ character outside of quotation marks, characters like !#$%&'*+-/=?^_`{|}~" +
                "(not used consequently unless in quotation marks) and (),:;<>@[] (used in quotation marks). ");
        Scanner input = new Scanner(System.in);
        email = input.nextLine();

        int at1 = email.indexOf("@");
        if (at1 == -1) {
            System.out.println("Address invalid. No @ sigh.");
            return;
        }
        int at2 = email.lastIndexOf("@");
        String localPart = email.substring(0, at2);
        if (localPart.length() > 64) {
            System.out.println("Address invalid. Too many characters in the domain.");
            return;
        }
        String domainPart = email.substring(at2, email.length()-1);
        if (domainPart.length() > 255) {
            System.out.println("Address invalid. Too many characters in the domain.");
            return;
        }
        int qu1 = email.indexOf('"');
        int qu2 = email.lastIndexOf('"');

        if (email.charAt(0) == '.') {
            System.out.println("Dot cannot be placed at the beginning of an email address");
            return;
        }
        for (int i = 0; i < email.lastIndexOf("@"); i++)
        {
            char c_i = email.charAt(i);
            if (qu1 == -1) //there are no quote marks
            {
                if (!(Character.isLetterOrDigit(c_i) || c_i == '.' || c_i == '!' || c_i == '#' || c_i == '$'
                        || c_i == '%' || c_i == '&' || c_i == '+' || c_i == '-' || c_i == '_'
                        || c_i == '"' || c_i == '@' || c_i == '*' || c_i == '/' || c_i == '=' || c_i == '?'
                        || c_i == '^' || c_i == '{' || c_i == '}' || c_i == '|' || c_i == '`' || c_i == '~'))
                {
                    System.out.println("Address doesn't contain only letters and given special characters.");
                    return;
                }
                if (!(Character.isLetterOrDigit(c_i) && Character.isLetterOrDigit(email.charAt(i + 1)))
                        && c_i == email.charAt(i + 1)) //there are special signs
                {
                    System.out.println("Two special characters used consequently.");
                    return;
                }
                if (at1 != email.lastIndexOf("@"))
                {
                    System.out.println("Only one @ is allowed outside quotation marks.");
                }
            }
            if (qu1 == qu2 && qu1 != -1) //tylko jeden cudzysłów
            {
                System.out.println("Number of quotation marks must be even.");
            }
            if (qu1 != -1 && qu2 != -1 && i < qu1) //sa dwa cudzysłowy a znak jest przed nimi
            {
                String partBeforeQuote = email.substring(0, i);
                int at_b1 = partBeforeQuote.indexOf("@");
                int at_b2 = partBeforeQuote.lastIndexOf("@");
                if (at_b2 != at_b1) {
                    System.out.println("Email address invalid. Too many @ signs outside of quotation marks.");
                    return;
                }
                if (!(Character.isLetterOrDigit(c_i) || c_i == '.' || c_i == '!' || c_i == '#' || c_i == '$'
                        || c_i == '%' || c_i == '&' || c_i == '+' || c_i == '-' || c_i == '_'
                        || c_i == '"' || c_i == '@' || c_i == '*' || c_i == '/' || c_i == '=' || c_i == '?'
                        || c_i == '^' || c_i == '{' || c_i == '}' || c_i == '|' || c_i == '`' || c_i == '~')) //jeśli żaden znak nie jest litera, cyfra lub dopuszczalnym znakiem
                {
                    System.out.println("Address doesn't contain only letters and few special characters ( !#$%&'*+-/=?^_`{|}~).");
                    return;
                }
                if (!(Character.isLetterOrDigit(c_i) && Character.isLetterOrDigit(email.charAt(i + 1)))
                        && c_i == email.charAt(i + 1)) //są powtarzajace się znaki specjalne
                {
                    System.out.println("Two special characters used consequently outside of quotation marks.");
                    return;
                }
            }
            if (qu1 != -1 && qu2 != -1 && i > qu2) //sa dwa cudzysłowy a znak jest za nimi
            {
                String partAfterQuote = email.substring(i, email.length()-1);
                int at_a1 = partAfterQuote.indexOf("@");
                int at_a2 = partAfterQuote.lastIndexOf("@");
                if (at_a1 != at_a2) {
                    System.out.println("Email address invalid. Too many @ signs outside of quotation marks.");
                    return;
                }
                if (!(Character.isLetterOrDigit(c_i) || c_i == '.' || c_i == '!' || c_i == '#' || c_i == '$'
                        || c_i == '%' || c_i == '&' || c_i == '+' || c_i == '-' || c_i == '_'
                        || c_i == '"' || c_i == '@' || c_i == '*' || c_i == '/' || c_i == '=' || c_i == '?'
                        || c_i == '^' || c_i == '{' || c_i == '}' || c_i == '|' || c_i == '`' || c_i == '~')) //jeśli żaden znak nie jest litera, cyfra lub dopuszczalnym znakiem
                {
                    System.out.println("Address doesn't contain only letters and few special characters ( !#$%&'*+-/=?^_`{|}~).");
                    return;
                }
                if (!(Character.isLetterOrDigit(c_i) && Character.isLetterOrDigit(email.charAt(i + 1)))
                        && c_i == email.charAt(i + 1)) //są powtarzajace się znaki specjalne
                {
                    System.out.println("Two special characters used consequently outside of quotation marks.");
                    return;
                }
            }
            if (qu1 != -1 && qu1 != qu2 && i > qu1 && i < qu2) //sa dwa cudzysłowy a znak jest pomiedzy nimi
            {
                if (!(Character.isLetterOrDigit(c_i) || c_i == '(' || c_i == ')' || c_i == ',' || c_i == ':' || c_i == '"'
                        || c_i == ';' || c_i == '<' || c_i == '>' || c_i == '@' || c_i == '[' || c_i == ']' || c_i == '.'
                        || c_i == '!' || c_i == '#' || c_i == '$'
                        || c_i == '%' || c_i == '&' || c_i == '+' || c_i == '-' || c_i == '_'
                        || c_i == '"' || c_i == '@' || c_i == '*' || c_i == '/' || c_i == '=' || c_i == '?'
                        || c_i == '^' || c_i == '{' || c_i == '}' || c_i == '|' || c_i == '`' || c_i == '~'))
                {
                    System.out.println("Unacceptable characters inside quotation marks(,():;<>@[/]) are allowed).");
                    return;
                }
            }
        }
        for (int j=email.lastIndexOf("@")+1; j < email.length()-1 ; j++)
        {
            char c_j = email.charAt(j);
            if (!(Character.isLetterOrDigit(c_j) || c_j == '.' || c_j == '-'))
            {
                System.out.println("Domain can contain only letter, numbers, a dot and a hyphen.");
                return;
            }
            if (!(Character.isLetterOrDigit(c_j) && Character.isLetterOrDigit(email.charAt(j + 1)))
                    && c_j == email.charAt(j + 1)) //są powtarzajace się znaki specjalne
            {
                System.out.println("Two special characters used consequently in the domain.");
                return;
            }

        }
        char lastLetter = email.charAt(email.length() - 1);
        if (!(Character.isLetterOrDigit(lastLetter) || lastLetter == '.' || lastLetter == '-'))
        {
            System.out.println("Domain can contain only letter, numbers, a dot and a hyphen(not used consequently).");
            return;
        }
        System.out.println("Your email address is " + email);
    }
}