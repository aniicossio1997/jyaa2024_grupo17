package grupo17.baseEntity;

public class IdentifiableBaseEntity {
    protected Long id;

    public Long getId() {
        return id;
    }

    public IdentifiableBaseEntity(Long id) {
        this.id = id;
    }
}
