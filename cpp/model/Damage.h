#ifndef CPP_DAMAGE_H
#define CPP_DAMAGE_H


class Damage {
public:
    explicit Damage(int amount);
    int getAmount() const;

private:
    int amount;

};


#endif //CPP_DAMAGE_H
