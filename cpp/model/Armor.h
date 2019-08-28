#ifndef FANTASYBATTLE_ARMOR_H
#define FANTASYBATTLE_ARMOR_H


class Armor {
public:
    explicit Armor(int soak);
    virtual int getDamageSoak() const;
protected:
    int soak;
};


#endif //FANTASYBATTLE_ARMOR_H
