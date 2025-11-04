import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;
import model.Account;
import model.Balance;
import model.Cards;
import model.Loans;
import services.AccountService;
import services.BalanceService;
import services.CardsService;
import services.LoansService;

public class App {
    private static final AccountService accountService = new AccountService();
    private static final BalanceService balanceService = new BalanceService();
    private static final LoansService loansService = new LoansService();
    private static final CardsService cardsService = new CardsService();

    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                printMainMenu();
                String option = sc.nextLine().trim();
                switch (option) {
                    case "1": runCrudMenu(sc, "Account"); break;
                    case "2": runCrudMenu(sc, "Balance"); break;
                    case "3": runCrudMenu(sc, "Loans"); break;
                    case "4": runCrudMenu(sc, "Cards"); break;
                    case "0": running = false; System.out.println("Saliendo..."); break;
                    default: System.out.println("Opción no válida.");
                }
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\n=== Menú Principal ===");
        System.out.println("1. Account");
        System.out.println("2. Balance");
        System.out.println("3. Loans");
        System.out.println("4. Cards");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void runCrudMenu(Scanner sc, String entity) {
        boolean back = false;
        while (!back) {
            printCrudMenu(entity);
            String opt = sc.nextLine().trim();
            switch (opt) {
                case "1": createEntity(sc, entity); break;
                case "2":
                    System.out.print("Ingrese id: ");
                    String id = sc.nextLine().trim();
                    readById(entity, id);
                    break;
                case "3": listAll(entity); break;
                case "4":
                    System.out.print("Ingrese id a actualizar: ");
                    String idUp = sc.nextLine().trim();
                    updateEntity(sc, entity, idUp);
                    break;
                case "5":
                    System.out.print("Ingrese id a eliminar: ");
                    String idDel = sc.nextLine().trim();
                    deleteById(entity, idDel);
                    break;
                case "0": back = true; break;
                default: System.out.println("Opción no válida.");
            }
        }
    }

    private static void printCrudMenu(String entity) {
        System.out.println("\n--- " + entity + " CRUD ---");
        System.out.println("1. Create");
        System.out.println("2. Read by id");
        System.out.println("3. List all");
        System.out.println("4. Update");
        System.out.println("5. Delete");
        System.out.println("0. Back");
        System.out.print("Seleccione una opción: ");
    }

    // Operaciones
    private static void createEntity(Scanner sc, String entity) {
        switch (entity) {
            case "Account":
                Account acc = readAccount(sc, null);
                accountService.save(acc);
                System.out.println("Creado: " + acc);
                break;
            case "Balance":
                Balance b = readBalance(sc, null);
                balanceService.save(b);
                System.out.println("Creado: " + b);
                break;
            case "Loans":
                Loans l = readLoans(sc, null);
                loansService.save(l);
                System.out.println("Creado: " + l);
                break;
            case "Cards":
                Cards c = readCard(sc, null);
                cardsService.save(c);
                System.out.println("Creado: " + c);
                break;
            default:
                System.out.println("Entidad no soportada: " + entity);
        }
    }

    private static void readById(String entity, String id) {
        switch (entity) {
            case "Account": {
                Optional<Account> o = accountService.findById(id);
                System.out.println(o.isPresent() ? o.get() : "No encontrado");
                break;
            }
            case "Balance": {
                Optional<Balance> o = balanceService.findById(id);
                System.out.println(o.isPresent() ? o.get() : "No encontrado");
                break;
            }
            case "Loans": {
                Optional<Loans> o = loansService.findById(id);
                System.out.println(o.isPresent() ? o.get() : "No encontrado");
                break;
            }
            case "Cards": {
                Optional<Cards> o = cardsService.findById(id);
                System.out.println(o.isPresent() ? o.get() : "No encontrado");
                break;
            }
            default: System.out.println("Entidad no soportada: " + entity);
        }
    }

    private static void listAll(String entity) {
        switch (entity) {
            case "Account": accountService.findAll().forEach(System.out::println); break;
            case "Balance": balanceService.findAll().forEach(System.out::println); break;
            case "Loans": loansService.findAll().forEach(System.out::println); break;
            case "Cards": cardsService.findAll().forEach(System.out::println); break;
            default: System.out.println("Entidad no soportada: " + entity);
        }
    }

    private static void updateEntity(Scanner sc, String entity, String id) {
        switch (entity) {
            case "Account":
                if (!accountService.existsById(id)) { System.out.println("No existe."); return; }
                Account accUpd = readAccount(sc, id);
                accountService.save(accUpd);
                System.out.println("Actualizado: " + accUpd);
                break;
            case "Balance":
                if (!balanceService.existsById(id)) { System.out.println("No existe."); return; }
                Balance bUpd = readBalance(sc, id);
                balanceService.save(bUpd);
                System.out.println("Actualizado: " + bUpd);
                break;
            case "Loans":
                if (!loansService.existsById(id)) { System.out.println("No existe."); return; }
                Loans lUpd = readLoans(sc, id);
                loansService.save(lUpd);
                System.out.println("Actualizado: " + lUpd);
                break;
            case "Cards":
                if (!cardsService.existsById(id)) { System.out.println("No existe."); return; }
                Cards cUpd = readCard(sc, id);
                cardsService.save(cUpd);
                System.out.println("Actualizado: " + cUpd);
                break;
            default:
                System.out.println("Entidad no soportada: " + entity);
        }
    }

    private static void deleteById(String entity, String id) {
        boolean res = false;
        switch (entity) {
            case "Account": res = accountService.deleteById(id); break;
            case "Balance": res = balanceService.deleteById(id); break;
            case "Loans": res = loansService.deleteById(id); break;
            case "Cards": res = cardsService.deleteById(id); break;
            default: System.out.println("Entidad no soportada: " + entity); return;
        }
        System.out.println(res ? "Eliminado." : "No encontrado.");
    }

    // Lectores
    private static Account readAccount(Scanner sc, String defaultId) {
        System.out.print("AccountNumber" + (defaultId != null ? " ("+defaultId+")" : "") + ": ");
        String id = sc.nextLine().trim();
        if (id.isEmpty() && defaultId != null) id = defaultId;
        System.out.print("Name: "); String name = sc.nextLine().trim();
        System.out.print("Email: "); String email = sc.nextLine().trim();
        System.out.print("MobileNumber: "); String mobile = sc.nextLine().trim();
        System.out.print("AccountType: "); String type = sc.nextLine().trim();
        System.out.print("Address: "); String addr = sc.nextLine().trim();
        return new Account(id, name, email, mobile, type, addr);
    }

    private static Balance readBalance(Scanner sc, String defaultId) {
        String id = defaultId != null ? defaultId : UUID.randomUUID().toString();
        System.out.println("Id: " + id);
        System.out.print("Date (YYYY-MM-DD): "); LocalDate date = parseDate(sc.nextLine().trim());
        System.out.print("Description: "); String desc = sc.nextLine().trim();
        System.out.print("CashIn: "); BigDecimal in = parseBig(sc.nextLine().trim());
        System.out.print("CashOut: "); BigDecimal out = parseBig(sc.nextLine().trim());
        System.out.print("ClosingBalance: "); BigDecimal close = parseBig(sc.nextLine().trim());
        return new Balance(id, date, desc, in, out, close);
    }

    private static Loans readLoans(Scanner sc, String defaultId) {
        String id = defaultId != null ? defaultId : UUID.randomUUID().toString();
        System.out.println("Id: " + id);
        System.out.print("Date (YYYY-MM-DD): "); LocalDate date = parseDate(sc.nextLine().trim());
        System.out.print("Type: "); String type = sc.nextLine().trim();
        System.out.print("TotalLoan: "); BigDecimal total = parseBig(sc.nextLine().trim());
        System.out.print("AmountPaid: "); BigDecimal paid = parseBig(sc.nextLine().trim());
        System.out.print("OutstandingAmt: "); BigDecimal out = parseBig(sc.nextLine().trim());
        return new Loans(id, date, type, total, paid, out);
    }

    private static Cards readCard(Scanner sc, String defaultId) {
        System.out.print("CardNumber" + (defaultId != null ? " ("+defaultId+")" : "") + ": ");
        String id = sc.nextLine().trim();
        if (id.isEmpty() && defaultId != null) id = defaultId;
        System.out.print("Type: "); String type = sc.nextLine().trim();
        System.out.print("TotalLimit: "); BigDecimal limit = parseBig(sc.nextLine().trim());
        System.out.print("AmountUsed: "); BigDecimal used = parseBig(sc.nextLine().trim());
        System.out.print("Available: "); BigDecimal avail = parseBig(sc.nextLine().trim());
        return new Cards(id, type, limit, used, avail);
    }

    private static LocalDate parseDate(String s) {
        try { return (s == null || s.isEmpty()) ? LocalDate.now() : LocalDate.parse(s); }
        catch (Exception e) { System.out.println("Fecha inválida. Usando hoy."); return LocalDate.now(); }
    }

    private static BigDecimal parseBig(String s) {
        try { return (s == null || s.isEmpty()) ? BigDecimal.ZERO : new BigDecimal(s); }
        catch (Exception e) { System.out.println("Número inválido. Usando 0."); return BigDecimal.ZERO; }
    }
}
